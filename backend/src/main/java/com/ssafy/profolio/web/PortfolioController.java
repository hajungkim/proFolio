package com.ssafy.profolio.web;

import com.ssafy.profolio.domain.portfolio.Portfolio;
import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.PortfolioService;
import com.ssafy.profolio.web.dto.PortfolioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping("/upload")
    public BaseResponse<PortfolioDto> uploadFile(PortfolioDto param){
        System.out.println(param);
        String url = portfolioService.uploadFile(param.getFile());
        PortfolioDto portfolio = portfolioService.putPortfolio(param, url);
        if (portfolio == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<PortfolioDto>(portfolio);
    }

    @GetMapping("/list")
    public BaseResponse<List<PortfolioDto>> getPortfolio(@RequestParam Long userId){
        List<PortfolioDto> list = portfolioService.getPortfolioList(userId);
        return new BaseResponse<List<PortfolioDto>>(list);
    }
}
