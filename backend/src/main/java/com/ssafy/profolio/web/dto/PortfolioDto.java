package com.ssafy.profolio.web.dto;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PortfolioDto {
    private MultipartFile file;
    private Long id;
    private String name;
    private String url;
    private Long userId;

    @Builder
    public PortfolioDto(MultipartFile file, Long id, String name, String url, Long userId){
        this.file = file;
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

}
