package com.ssafy.profolio.domain.awards;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "awards")
public class Awards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "awards_id")
    private Long id;

    @Column
    private String name;
    @Column
    private String prize;
    @Column
    private String description;
    @Column
    private String awards_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Awards() {}

    @Builder

    public Awards(Long id, String name, String prize, String description, String awards_date, Resume resume) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.awards_date = awards_date;
        this.resume = resume;
    }
}
