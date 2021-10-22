package com.ssafy.profolio.domain.user;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(length = 100)
    private String profile_path;

    @Column(length = 50, nullable = false)
    private String join_date;

    public User() {}

    @Builder
    public User(String email, String name, String phone, String profile_path, String join_date) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.profile_path = profile_path;
        this.join_date = join_date;
    }
}
