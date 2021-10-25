package com.ssafy.profolio.service;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.ssafy.profolio.helper.constants.SocialLoginType;
import com.ssafy.profolio.service.social.GoogleOauth;
import com.ssafy.profolio.service.social.NaverOauth;
import com.ssafy.profolio.service.social.SocialOauth;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final GoogleOauth googleOauth;
    private final NaverOauth naverOauth;
    private final HttpServletResponse response;
    private final List<SocialOauth> socialOauthList;


    public void request(SocialLoginType socialLoginType) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String redirectURL = socialOauth.getOauthRedirectURL();
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String requestAccessToken(SocialLoginType socialLoginType, String code) throws JSONException {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String result = socialOauth.requestAccessToken(code);

        JSONObject jObject = new JSONObject(result);
        String access_token = jObject.getString("access_token");

        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        String result2 = googleOauth.getUserInfo(access_token);
        System.out.println(result2);
        jObject = new JSONObject(result2);
        String userId = jObject.getString("id");
        String email = jObject.getString("email");
        String picture = jObject.getString("picture");
        String name = jObject.getString("name");


        System.out.println(userId);
        System.out.println(email);
        System.out.println(name);
        System.out.println(picture);
        return "";
    }

    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }

}
