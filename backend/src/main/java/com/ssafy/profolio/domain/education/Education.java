package com.ssafy.profolio.domain.education;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;

    @Column
    private String university;
    @Column
    private String Field4;
    @Column
    private String major;
    @Column
    private String minor;
    @Column
    private String admission_day;
    @Column
    private String graduation_day;
    @Column
    private String graduation;
    @Column
    private String score;
    @Column
    private String total_score;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Education() {}

    @Builder
    public Education(Long id, String university, String field4, String major, String minor, String admission_day, String graduation_day, String graduation, String score, String total_score, Resume resume) {
        this.id = id;
        this.university = university;
        Field4 = field4;
        this.major = major;
        this.minor = minor;
        this.admission_day = admission_day;
        this.graduation_day = graduation_day;
        this.graduation = graduation;
        this.score = score;
        this.total_score = total_score;
        this.resume = resume;
    }
}
