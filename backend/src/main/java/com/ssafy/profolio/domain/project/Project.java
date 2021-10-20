package com.ssafy.profolio.domain.project;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column
    private String title;
    @Column
    private String summary;
    @Column
    private String description;
    @Column
    private int member_cnt;
    @Column
    private String technology_stack;
    @Column
    private String role;
    @Column
    private String link;
    @Column
    private String start_date;
    @Column
    private String end_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Project() {}

    @Builder
    public Project(Long id, String title, String summary, String description, int member_cnt, String technology_stack, String role,
                   String link, String start_date, String end_date, Resume resume){
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.member_cnt = member_cnt;
        this.technology_stack = technology_stack;
        this.role = role;
        this.link = link;
        this.start_date = start_date;
        this.end_date = end_date;
        this.resume = resume;
    }
}
