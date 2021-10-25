package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.activity.ActivityRepository;
import com.ssafy.profolio.domain.awards.Awards;
import com.ssafy.profolio.domain.awards.AwardsRepository;
import com.ssafy.profolio.domain.career.Career;
import com.ssafy.profolio.domain.career.CareerRepository;
import com.ssafy.profolio.domain.certificate.Certificate;
import com.ssafy.profolio.domain.certificate.CertificateRepository;
import com.ssafy.profolio.domain.education.Education;
import com.ssafy.profolio.domain.education.EducationRepository;
import com.ssafy.profolio.domain.foreignlang.Foreignlang;
import com.ssafy.profolio.domain.foreignlang.ForeignlangRepository;
import com.ssafy.profolio.domain.project.Project;
import com.ssafy.profolio.domain.project.ProjectRepository;
import com.ssafy.profolio.domain.technologystack.TechnologyStack;
import com.ssafy.profolio.domain.technologystack.TechnologyStackRepository;
import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final AwardsRepository awardsRepository;
    private final CareerRepository careerRepository;
    private final CertificateRepository certificateRepository;
    private final EducationRepository educationRepository;
    private final ForeignlangRepository foreignlangRepository;
    private final ProjectRepository projectRepository;
    private final TechnologyStackRepository technologyStackRepository;



}
