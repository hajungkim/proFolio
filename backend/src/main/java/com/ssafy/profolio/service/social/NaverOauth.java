package com.ssafy.profolio.service.social;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverOauth implements SocialOauth {

    @Value("${spring.sns.naver.url}")
    private String NAVER_SNS_BASE_URL;

    @Value("${spring.sns.naver.client.id}")
    private String NAVER_SNS_CLIENT_ID;

    @Value("${spring.sns.naver.client.secret}")
    private String NAVER_SNS_CLIENT_SECRET;

    @Value("${spring.sns.naver.callback.url}")
    private String NAVER_SNS_CALLBACK_URL;

    @Value("${spring.sns.naver.token.url}")
    private String NAVER_SNS_TOKEN_BASE_URL;

    @Value("${spring.sns.naver.user.url}")
    private String NAVER_SNS_USER_URL;

    @Override
    public String getOauthRedirectURL() {

        Map<String, Object> params = new HashMap<>();

        params.put("client_id", NAVER_SNS_CLIENT_ID);
        params.put("response_type", "code");
        params.put("redirect_uri", NAVER_SNS_CALLBACK_URL);
        params.put("state", generateRandomString());

        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return NAVER_SNS_BASE_URL + "?" + parameterString;
    }

    @Override
    public String requestAccessToken(String code, String state) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> params = new HashMap<>();

        params.put("client_id", NAVER_SNS_CLIENT_ID);
        params.put("client_secret", NAVER_SNS_CLIENT_SECRET);
        params.put("grant_type", "authorization_code");
        params.put("state", state);
        params.put("code", code);

        String parameterString = params.entrySet().stream()
            .map(x -> x.getKey() + "=" + x.getValue())
            .collect(Collectors.joining("&"));

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(NAVER_SNS_TOKEN_BASE_URL+"?"+parameterString, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return "네이버 로그인 요청처리 실패";
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
        JSONObject jObject = new JSONObject(result);
        String refresh_token = jObject.getString("refresh_token");
        //System.out.println(access_token);
        return refresh_token;
    }

    @Override
    public String getUserInfo(String access_token) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + access_token);

        try {
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(NAVER_SNS_USER_URL, HttpMethod.GET, new HttpEntity(httpHeaders),
                                   String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        } catch (HttpClientErrorException e) {
            log.info(">>>>>>>> getUserInfo NAVER API 인증 실패 에러");
            e.printStackTrace();
        } catch (Exception e) {
            log.info(">>>>>>>> NAVER API 에러");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDto makeUserDto(String response_value) throws JSONException {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response_value);
        JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();

        String socailId = "NAVER-"+response.getAsJsonObject().get("id").getAsString();
        String email = response.getAsJsonObject().get("email").getAsString();
        String picture = response.getAsJsonObject().get("profile_image").getAsString();
        String name = response.getAsJsonObject().get("name").getAsString();
        String phone = response.getAsJsonObject().get("mobile").getAsString();

        log.info(">>>>>NAVE social Id: "+socailId);
        UserDto result = new UserDto(socailId, email,name,phone, "", picture);
        return result;
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }
}