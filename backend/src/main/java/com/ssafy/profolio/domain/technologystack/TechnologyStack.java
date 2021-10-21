package com.ssafy.profolio.domain.technologystack;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "technology_stack")
public class TechnologyStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_stack_id")
    private Long id;

    @Column
    private String name;
    @Column
    private String level;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public TechnologyStack() {}

    @Builder
    public TechnologyStack(String name, String level, String description, Resume resume){
        this.name = name;
        this.level = level;
        this.description = description;
        this.resume = resume;
    }
}
