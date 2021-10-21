package com.ssafy.profolio.domain.project;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "member_cnt")
    private Integer memberCnt;
    @Column(name = "technology_stack")
    private String technologyStack;
    @Column
    private String role;
    @Column
    private String link;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Project() {}

    @Builder
    public Project(Long id, String title, String summary, String description, Integer memberCnt, String technologyStack, String role,
                   String link, LocalDateTime startDate, LocalDateTime endDate, Resume resume){
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.memberCnt = memberCnt;
        this.technologyStack = technologyStack;
        this.role = role;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.resume = resume;
    }
}
