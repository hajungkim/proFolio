package com.ssafy.profolio.web;

import com.ssafy.profolio.helper.constants.SocialLoginType;
import com.ssafy.profolio.service.OauthService;
import com.ssafy.profolio.service.UserService;
import com.ssafy.profolio.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Slf4j
public class OauthController {

    private final OauthService oauthService;
    private final UserService userService;

    private final String signature = "LOGINTOKEN";
    private final Long expireMin = 30L;

    @Value("${spring.front.url}")
    private String front_url;

    /**
     * 사용자로부터 SNS 로그인 요청을 Social Login Type 을 받아 처리
     * @param socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
     */
    @GetMapping(value = "/{socialLoginType}")
    public void socialLoginType(
            @PathVariable(name = "socialLoginType") SocialLoginType socialLoginType) {
        log.info(">> 사용자로부터 SNS 로그인 요청을 받음 :: {} Social Login", socialLoginType);
        oauthService.request(socialLoginType);
    }

    /**
     * Social Login API Server 요청에 의한 callback 을 처리
     * socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
     * @param code API Server 로부터 넘어노는 code
     * @return SNS Login 요청 결과로 받은 Json 형태의 String 문자열 (access_token, refresh_token 등)
     */
    @GetMapping(value = "/google/callback")
    public void callback(
            @RequestParam(name = "code") String code,
            HttpServletResponse response) throws JSONException, IOException {
        log.info(">> GOOGLE 소셜 로그인 API 서버로부터 받은 code :: {}", code);

        SocialLoginType socialLoginType = SocialLoginType.GOOGLE;
        UserDto userDto= oauthService.requestAccessToken(socialLoginType, code, code);

        String token = userService.createToken(userDto);
        UserDto.loginResponse loginResponse = userService.createTokenUserId(token, userDto.getUserId());

        Cookie cookie = new Cookie("userId", String.valueOf(userDto.getUserId()));
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        response.sendRedirect(front_url);
    }
    @GetMapping(value = "/naver/callback")
    public void callback_naver(
            @RequestParam(name = "code") String code,
            @RequestParam(name = "state") String state,
            HttpServletResponse response) throws JSONException, IOException {
        log.info(">> NAVER 소셜 로그인 API 서버로부터 받은 code :: {}", code);
        log.info(">> NAVER 소셜 로그인 API 서버로부터 받은 state :: {}", state);

        SocialLoginType socialLoginType = SocialLoginType.NAVER;
        UserDto userDto= oauthService.requestAccessToken(socialLoginType, code, state);

        String token = userService.createToken(userDto);
        UserDto.loginResponse loginResponse = userService.createTokenUserId(token, userDto.getUserId());

        Cookie cookie = new Cookie("userId", String.valueOf(userDto.getUserId()));
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        response.sendRedirect(front_url);
    }
    @GetMapping(value = "/github/callback")
    public void callback_github(
            @RequestParam(name = "code") String code,
            HttpServletResponse response) throws JSONException, IOException {
        log.info(">> GITHUB 소셜 로그인 API 서버로부터 받은 code :: {}", code);

        SocialLoginType socialLoginType = SocialLoginType.GITHUB;
        UserDto userDto= oauthService.requestAccessToken(socialLoginType, code, code);

        String token = userService.createToken(userDto);
        UserDto.loginResponse loginResponse = userService.createTokenUserId(token, userDto.getUserId());

        Cookie cookie = new Cookie("userId", String.valueOf(userDto.getUserId()));
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        response.sendRedirect(front_url);
    }
}