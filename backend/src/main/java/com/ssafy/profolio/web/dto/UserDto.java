package com.ssafy.profolio.web.dto;

import com.ssafy.profolio.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class UserDto {
    private Long userId;
    private String socialId;
    private String email;
    private String name;
    private String phone;
    private String githubId;
    private String profilePath;
    private String description;

    @Builder
    public UserDto(String socialId, String email, String name, String phone, String githubId, String profilePath) {
        this.socialId = socialId;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.githubId = githubId;
        this.profilePath = profilePath;
        this.description="";
    }

    public UserDto(User user) {
        this.userId = user.getId();
        this.socialId = user.getSocialId();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.profilePath = user.getProfilePath();
        this.githubId = user.getGithubId();
        this.description=user.getDescription();
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
        private Long userId;
        private String email;
        private String name;
        private String phone;
        private String githubId;
        private String profilePath;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class UserRequest{
        private String email;
        private String name;
        private String phone;
        private String profilePath;
        private String githubId;
        private String description;
        private MultipartFile file;
    }

}
