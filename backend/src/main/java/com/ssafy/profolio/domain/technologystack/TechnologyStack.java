package com.ssafy.profolio.domain.technologystack;

import com.ssafy.profolio.domain.user.User;
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

    @Column
    private String name;

    @Column
    private String level;

    @Column(length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public TechnologyStack(String name, String level, String description, User user){
        this.name = name;
        this.level = level;
        this.description = description;
        this.user = user;
    }
}
