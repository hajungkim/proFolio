package com.ssafy.profolio.domain.project;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String description;

    @Column(name = "member_cnt", nullable = false)
    private Integer memberCnt;

    @Column(name = "technology_stack", nullable = false)
    private String technologyStack;

    @Column(nullable = false)
    private String role;

    @Column
    private String link;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date", nullable = false)
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Project(String title, String summary, String description, Integer memberCnt, String technologyStack, String role,
                   String link, String startDate, String endDate, User user){
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.memberCnt = memberCnt;
        this.technologyStack = technologyStack;
        this.role = role;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public void updateProject(ResumeDto.ProjectRequest request) {
        this.title = request.getTitle();
        this.summary = request.getSummary();
        this.description = request.getDescription();
        this.memberCnt = request.getMemberCnt();
        this.technologyStack = request.getTechnologyStack();
        this.role = request.getRole();
        this.link = request.getLink();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
    }
}
