package com.ssafy.profolio.domain.foreignlang;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "foreign_lang")
public class Foreignlang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foreign_lang_id")
    private Long id;

    @Column
    private String language;
    @Column
    private String name;
    @Column
    private String score;
    @Column(name = "certified_date")
    private LocalDateTime certifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Foreignlang() {}

    @Builder

    public Foreignlang(String language, String name, String score, LocalDateTime certifiedDate, Resume resume) {
        this.language = language;
        this.name = name;
        this.score = score;
        this.certifiedDate = certifiedDate;
        this.resume = resume;
    }
}
