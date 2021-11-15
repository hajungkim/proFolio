package com.ssafy.profolio.domain.education;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
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

    @Column(nullable = false)
    private String university;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String minor;

    @Column(name = "admission_date", nullable = false)
    private String admissionDate;

    @Column(name = "graduation_date", nullable = false)
    private String graduationDate;

    @Column(nullable = false)
    private boolean graduation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Education(String university, String major, String minor, String admissionDate, String graduationDate, boolean graduation, User user) {
        this.university = university;
        this.major = major;
        this.minor = minor;
        this.admissionDate = admissionDate;
        this.graduationDate = graduationDate;
        this.graduation = graduation;
        this.user = user;
    }

    public void updateEducation(ResumeDto.EducationRequest request) {
        this.university = request.getUniversity();
        this.major = request.getMajor();
        this.minor = request.getMinor();
        this.admissionDate = request.getAdmissionDate();
        this.graduationDate = request.getGraduationDate();
        this.graduation = request.isGraduation();
    }
}
