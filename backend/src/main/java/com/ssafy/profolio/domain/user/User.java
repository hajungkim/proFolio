package com.ssafy.profolio.domain.user;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.awards.Awards;
import com.ssafy.profolio.domain.career.Career;
import com.ssafy.profolio.domain.certificate.Certificate;
import com.ssafy.profolio.domain.foreignlang.Foreignlang;
import com.ssafy.profolio.domain.project.Project;
import com.ssafy.profolio.domain.technologystack.TechnologyStack;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(length = 500)
    private String profile_path;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String join_date;

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
    public User(String email, String name, String phone, String profile_path, String join_date) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.profile_path = profile_path;
        this.join_date = join_date;
    }
}
