package com.ssafy.profolio.domain.awards;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    @Column(length = 500)
    private String description;

    @Column(name = "awards_date")
    private String awardsDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Awards(String name, String prize, String description, String awardsDate, User user) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.awardsDate = awardsDate;
        this.user = user;
    }
}
