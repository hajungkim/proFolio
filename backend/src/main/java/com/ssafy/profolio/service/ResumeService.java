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
import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.web.BaseResponseCode;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<ResumeDto.ActivityResponse> findActivity(Long userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);
        List<ResumeDto.ActivityResponse> result = new ArrayList<>();
        for (Activity activity : activityList) {
            result.add(new ResumeDto.ActivityResponse(activity.getId(), activity.getName(), activity.getDescription(),
                    activity.getStartDate(), activity.getEndDate(), activity.getOrganization()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.AwardsResponse> findAwards(Long userId) {
        List<Awards> awardsList = awardsRepository.findByUserId(userId);
        List<ResumeDto.AwardsResponse> result = new ArrayList<>();
        for (Awards awards : awardsList) {
            result.add(new ResumeDto.AwardsResponse(awards.getId(), awards.getName(), awards.getPrize(),
                    awards.getDescription(), awards.getAwardsDate()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.CareerResponse> findCareer(Long userId) {
        List<Career> careerList = careerRepository.findByUserId(userId);
        List<ResumeDto.CareerResponse> result = new ArrayList<>();
        for (Career career : careerList) {
            result.add(new ResumeDto.CareerResponse(career.getId(), career.getCompany(), career.getDuty(),
                    career.getStartDate(), career.getEndDate(), career.getDescription()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.CertificateResponse> findCertificate(Long userId) {
        List<Certificate> certificateList = certificateRepository.findByUserId(userId);
        List<ResumeDto.CertificateResponse> result = new ArrayList<>();
        for (Certificate certificate : certificateList) {
            result.add(new ResumeDto.CertificateResponse(certificate.getId(), certificate.getName(),
                    certificate.getOrganization(), certificate.getCertifiedDate()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.ForeignLangResponse> findForeignLang(Long userId) {
        List<Foreignlang> foreignlangList = foreignlangRepository.findByUserId(userId);
        List<ResumeDto.ForeignLangResponse> result = new ArrayList<>();
        for (Foreignlang foreignlang : foreignlangList) {
            result.add(new ResumeDto.ForeignLangResponse(foreignlang.getId(), foreignlang.getLanguage(),
                    foreignlang.getName(), foreignlang.getScore(), foreignlang.getCertifiedDate()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.ProjectResponse> findProject(Long userId) {
        List<Project> projectList = projectRepository.findByUserId(userId);
        List<ResumeDto.ProjectResponse> result = new ArrayList<>();
        for (Project project : projectList) {
            result.add(new ResumeDto.ProjectResponse(project.getId(), project.getTitle(), project.getSummary(),
                    project.getDescription(), project.getMemberCnt(), project.getTechnologyStack(), project.getRole(),
                    project.getLink(), project.getStartDate(), project.getEndDate()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<ResumeDto.TechnologyStackResponse> findTechnologyStack(Long userId) {
        List<TechnologyStack> technologyStackList = technologyStackRepository.findByUserId(userId);
        List<ResumeDto.TechnologyStackResponse> result = new ArrayList<>();
        for (TechnologyStack technologyStack : technologyStackList) {
            result.add(new ResumeDto.TechnologyStackResponse(technologyStack.getId(), technologyStack.getName(), technologyStack.getLevel(),
                    technologyStack.getDescription(), technologyStack.getKind()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    public ResumeDto.EducationResponse findEducation(Long userId) {
        Education education = educationRepository.findByUserId(userId);
        if (education == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new ResumeDto.EducationResponse(education.getId(), education.getUniversity(), education.isMainSchool(),
                education.getMajor(), education.getMinor(), education.getAdmissionDate(), education.getGraduationDate(),
                education.isGraduation(), education.getScore(), education.getTotalScore());
    }
}
