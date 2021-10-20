package com.ssafy.profolio.domain.portfolio;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long id;

    @Column
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Portfolio() {}

    @Builder
    public Portfolio(Long id, String url, User user) {
        this.id = id;
        this.url = url;
        this.user = user;
    }
}
