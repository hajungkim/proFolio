package com.ssafy.profolio.domain.resume;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resume_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Resume() {}

    @Builder
    public Resume(Long id, User user){
        this.resume_id = id;
        this.user = user;
    }
}
