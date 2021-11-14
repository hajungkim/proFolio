package com.ssafy.profolio.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.profolio.domain.portfolio.Portfolio;
import com.ssafy.profolio.domain.portfolio.PortfolioRepository;
import com.ssafy.profolio.domain.user.UserRepository;
import com.ssafy.profolio.web.dto.PortfolioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PortfolioService {
    private final UploadService s3Service;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public List<PortfolioDto> getPortfolioList(Long userId){
        List<Portfolio> portfolios = portfolioRepository.getByUser(userRepository.getById(userId));
        List<PortfolioDto> results = new ArrayList<>();
        for(Portfolio portfolio : portfolios){
            results.add(portfolio.entityToDto());
        }
        return results;
    }

    public PortfolioDto putPortfolio(PortfolioDto param){
        String url = s3Service.uploadS3(param.getFile());
        Portfolio portfolio = portfolioRepository.save(Portfolio.builder()
            .name(param.getName()).url(url).user(userRepository.getById(param.getUserId())).build());
        return portfolio.entityToDto();
    }
}
