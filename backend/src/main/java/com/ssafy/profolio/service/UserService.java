package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.domain.user.UserRepository;
import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.web.BaseResponseCode;
import com.ssafy.profolio.web.dto.UserDto;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final String signature = "LOGINTOKEN";
    private final Long expireMin = 30L;

    private final UserRepository userRepository;

    public String createToken(UserDto userDto) {
        JwtBuilder jwtBuilder = Jwts.builder();
        //Header 설정
        jwtBuilder.setHeaderParam("typ", "JWT");    //토큰 타입으로 고정값
        //Payload 설정
        jwtBuilder
                .setSubject("로그인 토큰")   //토큰 제목
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin));    //유효기간
        //signature 설정
        jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());

        //마지막 직렬화 처리
        String jwt = jwtBuilder.compact();
        return jwt;
    }


    @Transactional
    public UserDto.loginResponse createTokenUserId(String token, Long userId) {
        UserDto.loginResponse response = UserDto.loginResponse.builder()
                .token(token).userId(userId).build();
        return response;
    }

    @Transactional
    public UserDto.UserResponse findUser(Long userId) {
        User user = userRepository.getById(userId);

        if(user == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);

        return new UserDto.UserResponse(user.getId(), user.getEmail(),
                user.getName(), user.getPhone(), user.getGithubId(), user.getProfilePath());
    }

    @Transactional
    public void updateUser(Long userId, UserDto.UserRequest request) {
        User user = userRepository.getById(userId);
        user.updateUser(request);
    }
}
