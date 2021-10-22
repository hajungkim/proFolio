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

    public String uploadFile(MultipartFile file){
        String fileName = createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        try(InputStream inputStream = file.getInputStream()){
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
        }catch (IOException e){
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생했습니다 (%s)", file.getOriginalFilename()));
        }
        return s3Service.getFileUrl(fileName);
    }

    private String createFileName(String originalFileName){
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String fileName){
        try{
            return fileName.substring(fileName.lastIndexOf("."));
        }catch (StringIndexOutOfBoundsException e){
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
        }
    }

    public Object getPortfolioList(Long userId){
        List<Portfolio> portfolios = portfolioRepository.getByUser(userRepository.getById(userId));
        List<PortfolioDto> results = new ArrayList<>();
        for(Portfolio portfolio : portfolios){
            results.add(portfolio.entityToDto());
        }
        return results;
    }

    public Portfolio putPortfolio(String name, String url){
        Portfolio portfolio = portfolioRepository.save(Portfolio.builder()
            .name(name).url(url).build());
        return portfolio;
    }
}
