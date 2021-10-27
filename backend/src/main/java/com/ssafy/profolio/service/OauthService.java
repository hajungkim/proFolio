package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.domain.user.UserRepository;
import com.ssafy.profolio.helper.constants.SocialLoginType;
import com.ssafy.profolio.service.social.GoogleOauth;
import com.ssafy.profolio.service.social.NaverOauth;
import com.ssafy.profolio.service.social.SocialOauth;
import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OauthService {

    private final HttpServletResponse response;
    private final List<SocialOauth> socialOauthList;

    private final UserRepository userRepository;

    public void request(SocialLoginType socialLoginType) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String redirectURL = socialOauth.getOauthRedirectURL();
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public UserDto requestAccessToken(SocialLoginType socialLoginType, String code, String state) throws JSONException {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);

        //받아온 code 값을 이용해서 access token 발급을 요청
        String accessResult = socialOauth.requestAccessToken(code, state);
        log.info("\n>>>>> access token 요청 결과 : "+accessResult);

        //access_token parsing
        String access_token = socialOauth.getToken(accessResult);
        log.info("\n>>>>> access token 값 : "+accessResult);

        //파싱한 access token을 이용해서 userinfo 프로필 정보 받아오기
        String userinfo = socialOauth.getUserInfo(access_token);
        log.info("\n>>>>> 받아온 유저 정보 : " + userinfo);

        UserDto userDto = socialOauth.makeUserDto(userinfo);

        User user = userRepository.findBySocialId(userDto.getSocial_id()).orElseGet(
                () -> {
                    User newUser = User.builder()
                            .social_id(userDto.getSocial_id())
                            .email(userDto.getEmail())
                            .name(userDto.getName())
                            .phone(userDto.getPhone())
                            .profile_path(userDto.getProfile_path())
                            .build();
                    userRepository.save(newUser);
                    return newUser;
                }
        );




        return userDto;
    }

    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }

}
