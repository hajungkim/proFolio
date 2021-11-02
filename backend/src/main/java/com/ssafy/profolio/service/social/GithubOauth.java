package com.ssafy.profolio.service.social;

import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GithubOauth implements SocialOauth {

    @Value("${sns.github.url}")
    private String GITHUB_SNS_BASE_URL;
    @Value("${sns.github.client.id}")
    private String GITHUB_SNS_CLIENT_ID;
    @Value("${sns.github.callback.url}")
    private String GITHUB_SNS_CALLBACK_URL;
    @Value("${sns.github.client.secret}")
    private String GITHUB_SNS_CLIENT_SECRET;
    @Value("${sns.github.token.url}")
    private String GITHUB_SNS_TOKEN_BASE_URL;
    @Value("${sns.github.user.url}")
    private String GITHUB_SNS_USER_URL;

    @Override
    public String getOauthRedirectURL() {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", GITHUB_SNS_CLIENT_ID);
        params.put("redirect_uri", GITHUB_SNS_CALLBACK_URL);

        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return GITHUB_SNS_BASE_URL + "?" + parameterString;
    }

    @Override
    public String requestAccessToken(String state, String code) {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println(code);
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", GITHUB_SNS_CLIENT_ID);
        params.put("client_secret", GITHUB_SNS_CLIENT_SECRET);

        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(GITHUB_SNS_TOKEN_BASE_URL, params, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return "깃허브 로그인 요청 처리 실패";
    }

    @Override
    public String getAccessToken(String result) throws JSONException {
        System.out.println(result);
        String[] temp = result.split("&");
        String[] temp2 = temp[0].split("=");
        String access_token = temp2[1];
        return access_token;
    }

    @Override
    public String getRefreshToken(String result) throws JSONException {
        return null;
    }

    @Override
    public String getUserInfo(String access_token) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "token "+access_token);

        try {
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(GITHUB_SNS_USER_URL, HttpMethod.GET, new HttpEntity(httpHeaders),
                            String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        } catch (HttpClientErrorException e) {
            log.info(">>>>>>>> getUserInfo GITHUB API 인증 실패 에러");
            e.printStackTrace();
        } catch (Exception e) {
            log.info(">>>>>>>> GITHUB API 에러");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDto makeUserDto(String response) throws JSONException {

        JSONObject jObject = new JSONObject(response);

        String socailId = "GITHUB-"+jObject.getInt("id");

        String email = null;
        String picture = null;
        String name = null;

        if(!jObject.isNull("email"))  email = (String) jObject.get("email");
        if(!jObject.isNull("avatar_url")) picture = jObject.getString("avatar_url");
        if(!jObject.isNull("name")) name = jObject.getString("name");

        log.info(">>>>>GITHUB social Id: " + socailId);

        UserDto result = new UserDto(socailId, email, name,null,null,picture);
        return result;
    }
}
