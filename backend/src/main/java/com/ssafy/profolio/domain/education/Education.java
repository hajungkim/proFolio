package com.ssafy.profolio.domain.education;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "admission_day")
    private LocalDateTime admissionDay;
    @Column(name = "graduation_day")
    private LocalDateTime graduationDay;
    @Column
    private String graduation;
    @Column
    private String score;
    @Column(name = "total_score")
    private Long totalScore;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Education() {}

    @Builder
    public Education(Long id, String university, String field4, String major, String minor, LocalDateTime admissionDay, LocalDateTime graduationDay, String graduation, String score, Long totalScore, Resume resume) {
        this.id = id;
        this.university = university;
        Field4 = field4;
        this.major = major;
        this.minor = minor;
        this.admissionDay = admissionDay;
        this.graduationDay = graduationDay;
        this.graduation = graduation;
        this.score = score;
        this.totalScore = totalScore;
        this.resume = resume;
    }
}
