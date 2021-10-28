package com.ssafy.profolio.web.dto;

import com.ssafy.profolio.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserDto {
    private Long user_id;
    private String social_id;
    private String email;
    private String name;
    private String phone;
    private String birthday;
    private String profile_path;
    private String access_token;
    private String refresh_token;

    @Builder
    public UserDto(String social_id, String email, String name, String phone, String birthday, String profile_path) {
        this.social_id = social_id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.profile_path = profile_path;
    }

    public UserDto(User user) {
        this.user_id = user.getId();
        this.social_id = user.getSocialId();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.profile_path = user.getProfile_path();
        this.birthday = user.getBirthday();
        this.access_token = user.getAccessToken();
        this.refresh_token = user.getRefreshToken();
    }

    public void addToken(String access_token, String refresh_token) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }

    @Getter
    @NoArgsConstructor
    public static class loginResponse {
        private String token;
        private Long userId;

        @Builder
        public loginResponse(String token, Long userId) {
            this.token = token;
            this.userId = userId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class UserResponse{
        private Long user_id;
        private String email;
        private String name;
        private String phone;
        private String birthday;
        private String profile_path;
    }

    @Getter
    @AllArgsConstructor
    public static class UserRequest{
        private String email;
        private String name;
        private String phone;
        private String profile_path;
        private String birthday;
    }

}
