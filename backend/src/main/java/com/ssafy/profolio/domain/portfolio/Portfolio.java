package com.ssafy.profolio.domain.portfolio;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.PortfolioDto;
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

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Portfolio() {}

    @Builder
    public Portfolio(String url, String name, User user) {
        this.url = url;
        this.name = name;
        this.user = user;
    }

    public PortfolioDto entityToDto(){
        return PortfolioDto.builder().id(id).name(name).url(url).userId(user.getId()).build();
    }
}
