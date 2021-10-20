package com.ssafy.profolio.domain.career;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrer_id")
    private Long id;

    @Column
    private String field;
    @Column
    private String duty;
    @Column
    private String start_date;
    @Column
    private String end_date;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Career() {}

    @Builder
    public Career(Long id, String field, String duty, String start_date, String end_date, String description, Resume resume) {
        this.id = id;
        this.field = field;
        this.duty = duty;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.resume = resume;
    }
}
