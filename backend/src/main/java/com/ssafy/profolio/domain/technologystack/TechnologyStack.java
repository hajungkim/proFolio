package com.ssafy.profolio.domain.technologystack;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "technology_stack")
public class TechnologyStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_stack_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private int kind;       // 기술스택 종류 1:언어 2:프레임워크 3:DB

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public TechnologyStack(String name, String level, int kind, User user){
        this.name = name;
        this.level = level;
        this.kind = kind;
        this.user = user;
    }

    public void updateTechnologyStack(ResumeDto.TechnologyStackRequest request) {
        this.name = request.getName();
        this.level = request.getLevel();
        this.kind = request.getKind();
    }
}
