package com.ssafy.profolio.service.social;

import com.ssafy.profolio.helper.constants.SocialLoginType;
import com.ssafy.profolio.web.dto.UserDto;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface SocialOauth {

    default SocialLoginType type() {
        if (this instanceof GoogleOauth) {
            return SocialLoginType.GOOGLE;
        } else if (this instanceof NaverOauth) {
            return SocialLoginType.NAVER;
        } else if (this instanceof GithubOauth) {
            return SocialLoginType.GITHUB;
        } else {
            return null;
        }
    }

    /**
     * 각 Social Login 페이지로 Redirect 처리할 URL Build
     * 사용자로부터 로그인 요청을 받아 Social Login Server 인증용 code 요
     */
    String getOauthRedirectURL();

    /**
     * API Server로부터 받은 code를 활용하여 사용자 인증 정보 요청
     *
     * @param s
     * @param code API Server 에서 받아온 code
     * @return API 서버로 부터 응답받은 Json 형태의 결과를 string으로 반
     */
    String requestAccessToken(String s, String code);

    String getToken(String result) throws JSONException;

    String getUserInfo(String access_token);

    UserDto makeUserDto(String response) throws JSONException;
}