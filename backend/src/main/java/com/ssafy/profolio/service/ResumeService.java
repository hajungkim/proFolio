package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.resume.ResumRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private final ResumRepository resumRepository;

    public ResumeService(ResumRepository resumRepository){
        this.resumRepository = resumRepository;
    }
}
