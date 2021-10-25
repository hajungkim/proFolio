package com.ssafy.profolio.domain.education;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;

    @Column
    private String university;

    @Column(name = "main_school")
    private boolean mainSchool;

    @Column
    private String major;

    @Column
    private String minor;

    @Column(name = "admission_date")
    private String admissionDate;

    @Column(name = "graduation_date")
    private String graduationDate;

    @Column
    private boolean graduation;

    @Column
    private String score;

    @Column(name = "total_score")
    private Long totalScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Education(String university, boolean mainSchool, String major, String minor, String admissionDate, String graduationDate, boolean graduation, String score, Long totalScore, User user) {
        this.university = university;
        this.mainSchool = mainSchool;
        this.major = major;
        this.minor = minor;
        this.admissionDate = admissionDate;
        this.graduationDate = graduationDate;
        this.graduation = graduation;
        this.score = score;
        this.totalScore = totalScore;
        this.user = user;
    }
}
