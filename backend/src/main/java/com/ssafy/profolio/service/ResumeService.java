package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.activity.ActivityRepository;
import com.ssafy.profolio.domain.awards.AwardsRepository;
import com.ssafy.profolio.domain.career.CareerRepository;
import com.ssafy.profolio.domain.certificate.CertificateRepository;
import com.ssafy.profolio.domain.education.EducationRepository;
import com.ssafy.profolio.domain.foreignlang.ForeignlangRepository;
import com.ssafy.profolio.domain.project.ProjectRepository;
import com.ssafy.profolio.domain.resume.ResumRepository;
import com.ssafy.profolio.domain.resume.Resume;
import com.ssafy.profolio.domain.technologystack.TechnologyStackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumRepository resumRepository;
    private final ActivityRepository activityRepository;
    private final AwardsRepository awardsRepository;
    private final CareerRepository careerRepository;
    private final CertificateRepository certificateRepository;
    private final EducationRepository educationRepository;
    private final ForeignlangRepository foreignlangRepository;
    private final ProjectRepository projectRepository;
    private final TechnologyStackRepository technologyStackRepository;

//    @Transactional
//    public void saveResume(Long userId) {
//        Resume resume = Resume.builder()
//                .user(userId)
//                .build();
//    }

}
