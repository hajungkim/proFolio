package com.ssafy.profolio.domain.foreignlang;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

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
    @Column
    private String certified_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Foreignlang() {}

    @Builder

    public Foreignlang(Long id, String language, String name, String score, String certified_date, Resume resume) {
        this.id = id;
        this.language = language;
        this.name = name;
        this.score = score;
        this.certified_date = certified_date;
        this.resume = resume;
    }
}
