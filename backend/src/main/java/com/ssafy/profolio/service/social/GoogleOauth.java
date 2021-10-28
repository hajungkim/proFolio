package com.ssafy.profolio.service.social;

import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleOauth implements SocialOauth {

    @Value("${sns.google.url}")
    private String GOOGLE_SNS_BASE_URL;
    @Value("${sns.google.client.id}")
    private String GOOGLE_SNS_CLIENT_ID;
    @Value("${sns.google.callback.url}")
    private String GOOGLE_SNS_CALLBACK_URL;
    @Value("${sns.google.client.secret}")
    private String GOOGLE_SNS_CLIENT_SECRET;
    @Value("${sns.google.token.url}")
    private String GOOGLE_SNS_TOKEN_BASE_URL;
    @Value("${sns.google.user.url}")
    private String GOOGLE_SNS_USER_URL;

    @Override
    public String getOauthRedirectURL() {
        Map<String, Object> params = new HashMap<>();
        params.put("scope", "profile email openid");
        params.put("response_type", "code");
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);

        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return GOOGLE_SNS_BASE_URL + "?" + parameterString;
    }

    @Override
    public String requestAccessToken(String state, String code) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("client_secret", GOOGLE_SNS_CLIENT_SECRET);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);
        params.put("grant_type", "authorization_code");

        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(GOOGLE_SNS_TOKEN_BASE_URL, params, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return "구글 로그인 요청 처리 실패";
    }

    @Override
    public String getAccessToken(String result) throws JSONException {
        JSONObject jObject = new JSONObject(result);
        String access_token = jObject.getString("access_token");
        //System.out.println(access_token);
        return access_token;
    }

    @Override
    public String getRefreshToken(String result) throws JSONException {
        return null;
    }

    @Override
    public String getUserInfo(String access_token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity =
                    restTemplate.getForEntity(GOOGLE_SNS_USER_URL + "/?access_token=" + access_token, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        } catch (HttpClientErrorException e) {
            log.info(">>>>>>>> getUserInfo GOOGLE API 인증 실패 에러");
            e.printStackTrace();
        } catch (Exception e) {
            log.info(">>>>>>>> GOOGLE API 에러");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDto makeUserDto(String response) throws JSONException {
        JSONObject jObject = new JSONObject(response);

        String socailId = "GOOGLE-"+jObject.getString("id");
        String email = jObject.getString("email");
        String picture = jObject.getString("picture");
        String name = jObject.getString("name");

        log.info(">>>>>GOOGLE social Id: " + socailId);

        UserDto result = new UserDto(socailId, email,name,null,null,picture);
        return result;
    }
}