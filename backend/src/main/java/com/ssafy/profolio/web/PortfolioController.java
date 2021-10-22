package com.ssafy.profolio.web;

import com.ssafy.profolio.domain.portfolio.Portfolio;
import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping("/upload")
    public BaseResponse<Portfolio> uploadFile(@RequestPart MultipartFile file, @RequestParam String name){
        String url = portfolioService.uploadFile(file);
        Portfolio portfolio = portfolioService.putPortfolio(name, url);
        if (portfolio == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<Portfolio>(portfolio);
    }

    @GetMapping("/list")
    public BaseResponse<List<Portfolio>> getPortfolio(@RequestParam Long userId){

        return null;
    }
}
