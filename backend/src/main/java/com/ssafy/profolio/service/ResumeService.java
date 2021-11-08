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
                    certificate.getCertifiedDate()));
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
            result.add(new ResumeDto.TechnologyStackResponse(technologyStack.getId(), technologyStack.getName(),
                    technologyStack.getLevel(), technologyStack.getKind()));
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

    @Transactional
    public void saveActivity(ResumeDto.ActivityRequest request) {
        User user = userRepository.getById(request.getUserId());
        Activity activity = Activity.builder()
                .name(request.getName())
                .organization(request.getOrganization())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .description(request.getDescription())
                .user(user).build();
        activityRepository.save(activity);
    }

    @Transactional
    public void saveAwards(ResumeDto.AwardsRequest request) {
        User user = userRepository.getById(request.getUserId());
        Awards awards = Awards.builder()
                .name(request.getName())
                .prize(request.getPrize())
                .description(request.getDescription())
                .awardsDate(request.getAwardsDate())
                .user(user).build();
        awardsRepository.save(awards);
    }

    @Transactional
    public void saveCareer(ResumeDto.CareerRequest request) {
        User user = userRepository.getById(request.getUserId());
        Career career = Career.builder()
                .company(request.getCompany())
                .duty(request.getDuty())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .description(request.getDescription())
                .user(user).build();
        careerRepository.save(career);
    }

    @Transactional
    public void saveCertificate(ResumeDto.CertificateRequest request) {
        User user = userRepository.getById(request.getUserId());
        Certificate certificate = Certificate.builder()
                .name(request.getName())
                .certifiedDate(request.getCertifiedDate())
                .user(user).build();
        certificateRepository.save(certificate);
    }

    @Transactional
    public void saveEducation(ResumeDto.EducationRequest request) {
        User user = userRepository.getById(request.getUserId());
        Education education = Education.builder()
                .university(request.getUniversity())
                .mainSchool(request.isMainSchool())
                .major(request.getMajor())
                .minor(request.getMinor())
                .admissionDate(request.getAdmissionDate())
                .graduationDate(request.getGraduationDate())
                .graduation(request.isGraduation())
                .score(request.getScore())
                .totalScore(request.getTotalScore())
                .user(user).build();
        educationRepository.save(education);
    }

    @Transactional
    public void saveForeignLang(ResumeDto.ForeignLangRequest request) {
        User user = userRepository.getById(request.getUserId());
        Foreignlang foreignlang = Foreignlang.builder()
                .language(request.getLanguage())
                .name(request.getName())
                .score(request.getScore())
                .certifiedDate(request.getCertifiedDate())
                .user(user).build();
        foreignlangRepository.save(foreignlang);
    }

    @Transactional
    public void saveProject(ResumeDto.ProjectRequest request) {
        User user = userRepository.getById(request.getUserId());
        Project project = Project.builder()
                .title(request.getTitle())
                .summary(request.getSummary())
                .description(request.getDescription())
                .memberCnt(request.getMemberCnt())
                .technologyStack(request.getTechnologyStack())
                .role(request.getRole())
                .link(request.getLink())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .user(user).build();
        projectRepository.save(project);
    }

    @Transactional
    public void saveTechnologyStack(ResumeDto.TechnologyStackRequest request) {
        User user = userRepository.getById(request.getUserId());
        TechnologyStack technologyStack = TechnologyStack.builder()
                .name(request.getName())
                .level(request.getLevel())
                .kind(request.getKind())
                .user(user).build();
        technologyStackRepository.save(technologyStack);
    }

    @Transactional
    public void updateActivity(Long id, ResumeDto.ActivityRequest request) {
        Activity activity = activityRepository.getById(id);
        activity.updateActivity(request);
    }

    @Transactional
    public void updateAwards(Long id, ResumeDto.AwardsRequest request) {
        Awards awards = awardsRepository.getById(id);
        awards.updateAwards(request);
    }

    @Transactional
    public void updateCareer(Long id, ResumeDto.CareerRequest request) {
        Career career = careerRepository.getById(id);
        career.updateCareer(request);
    }

    @Transactional
    public void updateCertificate(Long id, ResumeDto.CertificateRequest request) {
        Certificate certificate = certificateRepository.getById(id);
        certificate.updateCertificate(request);
    }

    @Transactional
    public void updateEducation(Long id, ResumeDto.EducationRequest request) {
        Education education = educationRepository.findByUserId(id);
        education.updateEducation(request);
    }

    @Transactional
    public void updateForeignLang(Long id, ResumeDto.ForeignLangRequest request) {
        Foreignlang foreignlang = foreignlangRepository.getById(id);
        foreignlang.updateForeignLang(request);
    }

    @Transactional
    public void updateProject(Long id, ResumeDto.ProjectRequest request) {
        Project project = projectRepository.getById(id);
        project.updateProject(request);
    }

    @Transactional
    public void updateTechnologyStack(Long id, ResumeDto.TechnologyStackRequest request) {
        TechnologyStack technologyStack = technologyStackRepository.getById(id);
        technologyStack.updateTechnologyStack(request);
    }

    @Transactional
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    @Transactional
    public void deleteAwards(Long id) {
        awardsRepository.deleteById(id);
    }

    @Transactional
    public void deleteCareer(Long id) {
        careerRepository.deleteById(id);
    }

    @Transactional
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }

    @Transactional
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Transactional
    public void deleteForeignLang(Long id) {
        foreignlangRepository.deleteById(id);
    }

    @Transactional
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Transactional
    public void deleteTechnologyStack(Long id) {
        technologyStackRepository.deleteById(id);
    }

}
