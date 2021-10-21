package com.ssafy.profolio.domain.resume;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.awards.Awards;
import com.ssafy.profolio.domain.career.Career;
import com.ssafy.profolio.domain.certificate.Certificate;
import com.ssafy.profolio.domain.foreignlang.Foreignlang;
import com.ssafy.profolio.domain.project.Project;
import com.ssafy.profolio.domain.technologystack.TechnologyStack;
import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<TechnologyStack> technologyStackList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Activity> activityList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Awards> awardsList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Career> careerList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Foreignlang> foreignlangList = new ArrayList<>();

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    public Resume() {}

    @Builder
    public Resume(User user){
        this.user = user;
    }
}
