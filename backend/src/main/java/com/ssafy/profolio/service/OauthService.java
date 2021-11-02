package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.domain.user.UserRepository;
import com.ssafy.profolio.helper.constants.SocialLoginType;
import com.ssafy.profolio.service.social.SocialOauth;
import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
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
        String access_token = socialOauth.getAccessToken(accessResult);
        log.info("\n>>>>> access token 값 : "+accessResult);

        //access_token parsing
        String refresh_token = socialOauth.getRefreshToken(accessResult);
        log.info("\n>>>>> refresh token 값 : "+refresh_token);

        //파싱한 access token을 이용해서 userinfo 프로필 정보 받아오기
        String userinfo = socialOauth.getUserInfo(access_token);
        log.info("\n>>>>> 받아온 유저 정보 : " + userinfo);

        UserDto userDto = socialOauth.makeUserDto(userinfo);

        //DB에 없는 유저일 경우, DB에 저장
        User user = userRepository.findBySocialId(userDto.getSocialId()).orElseGet(
                () -> {
                    User newUser = User.builder()
                            .social_id(userDto.getSocialId())
                            .accessToken(access_token)
                            .refreshToken(refresh_token)
                            .email(userDto.getEmail())
                            .name(userDto.getName())
                            .phone(userDto.getPhone())
                            .birthday(userDto.getBirthday())
                            .profilePath(userDto.getProfilePath())
                            .build();
                    userRepository.save(newUser);
                    return newUser;
                }
        );

        return new UserDto(user);
    }

    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }

}
