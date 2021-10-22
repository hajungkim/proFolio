package com.ssafy.profolio.domain.awards;

import com.ssafy.profolio.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "awards_date")
    private LocalDateTime awardsDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Awards() {}

    @Builder

    public Awards(String name, String prize, String description, LocalDateTime awardsDate, Resume resume) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.awardsDate = awardsDate;
        this.resume = resume;
    }
}
