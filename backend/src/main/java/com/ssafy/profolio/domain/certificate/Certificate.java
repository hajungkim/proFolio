package com.ssafy.profolio.domain.certificate;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long id;

    @Column
    private String name;
    @Column
    private String organization;
    @Column(name = "certified_date")
    private LocalDateTime certifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Certificate() {}

    @Builder
    public Certificate(String name, String organization, LocalDateTime certifiedDate, Resume resume) {
        this.name = name;
        this.organization = organization;
        this.certifiedDate = certifiedDate;
        this.resume = resume;
    }
}
