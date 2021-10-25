package com.ssafy.profolio.domain.project;

import com.ssafy.profolio.domain.user.User;
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
    private String startDate;

    @Column(name = "end_date")
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
}
