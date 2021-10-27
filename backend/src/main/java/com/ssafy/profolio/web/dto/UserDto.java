package com.ssafy.profolio.web.dto;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class UserDto {
    private String social_id;
    private String email;
    private String name;
    private String phone;
    private String profile_path;

    @Builder
    public UserDto(String social_id, String email, String name, String phone, String profile_path) {
        this.social_id = social_id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.profile_path = profile_path;
    }
}
