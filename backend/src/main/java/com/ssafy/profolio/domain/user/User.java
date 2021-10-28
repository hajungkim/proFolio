package com.ssafy.profolio.domain.user;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.awards.Awards;
import com.ssafy.profolio.domain.career.Career;
import com.ssafy.profolio.domain.certificate.Certificate;
import com.ssafy.profolio.domain.foreignlang.Foreignlang;
import com.ssafy.profolio.domain.project.Project;
import com.ssafy.profolio.domain.technologystack.TechnologyStack;
import com.ssafy.profolio.web.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "social_id", nullable = false)
    private String socialId;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Column
    private String birthday;

    @Column(length = 500)
    private String profile_path;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime join_date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TechnologyStack> technologyStackList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Activity> activityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Awards> awardsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Career> careerList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Foreignlang> foreignlangList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    @Builder
    public User(String accessToken, String refreshToken, String social_id, String email, String name, String phone, String birthday, String profile_path) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.socialId = social_id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.profile_path = profile_path;
        this.join_date = LocalDateTime.now();
    }

    public void updateUser(UserDto.UserRequest request) {
        this.email = request.getEmail();
        this.name = request.getName();
        this.phone = request.getPhone();
        this.profile_path = request.getProfile_path();
        this.birthday = request.getBirthday();
    }
}
