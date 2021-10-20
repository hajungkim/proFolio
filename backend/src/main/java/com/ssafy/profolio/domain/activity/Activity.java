package com.ssafy.profolio.domain.activity;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    @Column
    private String name;
    @Column
    private String organization;
    @Column
    private String start_date;
    @Column
    private String end_date;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Activity() {}

    @Builder
    public Activity(Long id, String name, String organization, String start_date, String end_date, String description, Resume resume) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.resume = resume;
    }
}
