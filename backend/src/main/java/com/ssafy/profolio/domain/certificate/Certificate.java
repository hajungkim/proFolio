package com.ssafy.profolio.domain.certificate;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

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
    @Column
    private String certified_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Certificate() {}

    @Builder
    public Certificate(Long id, String name, String organization, String certified_date, Resume resume) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.certified_date = certified_date;
        this.resume = resume;
    }
}
