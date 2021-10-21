package com.ssafy.profolio.web;

import com.ssafy.profolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart MultipartFile file){
        return portfolioService.uploadFile(file);
    }

}
