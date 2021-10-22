package com.ssafy.profolio.web.dto;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PortfolioDto {
    private Long id;
    private String name;
    private String url;
    private Long userId;

    @Builder
    public PortfolioDto(Long id, String name, String url, Long userId){
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

}
