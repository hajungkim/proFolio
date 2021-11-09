package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.activity.ActivityRepository;
import com.ssafy.profolio.domain.awards.Awards;
import com.ssafy.profolio.domain.awards.AwardsRepository;
import com.ssafy.profolio.domain.career.CareerRepository;
import com.ssafy.profolio.domain.certificate.CertificateRepository;
import com.ssafy.profolio.domain.education.Education;
import com.ssafy.profolio.domain.education.EducationRepository;
import com.ssafy.profolio.domain.foreignlang.ForeignlangRepository;
import com.ssafy.profolio.domain.project.ProjectRepository;
import com.ssafy.profolio.domain.technologystack.TechnologyStackRepository;
import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.domain.user.UserRepository;
import com.ssafy.profolio.web.dto.ResumeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResumeServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ActivityRepository activityRepository;
    @Mock
    private AwardsRepository awardsRepository;
    @Mock
    private CareerRepository careerRepository;
    @Mock
    private CertificateRepository certificateRepository;
    @Mock
    private EducationRepository educationRepository;
    @Mock
    private ForeignlangRepository foreignlangRepository;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private TechnologyStackRepository technologyStackRepository;
    @InjectMocks
    private ResumeService resumeService;

    private final Long USER_ID = 1L;

    private User user = User.builder()
            .accessToken("test")
            .refreshToken("test")
            .socialId("1")
            .email("test")
            .name("test")
            .phone("test")
            .birthday("test")
            .profilePath("test")
            .build();

    @BeforeEach
    public void setUp() {
        resumeService = new ResumeService(userRepository, activityRepository, awardsRepository,careerRepository,
                certificateRepository, educationRepository, foreignlangRepository, projectRepository, technologyStackRepository);
    }

    @Test
    @DisplayName("should find all activity")
    void findActivity() {
        // given
        List<Activity> activityList = Arrays.asList(
                Activity.builder().name("test1").user(user).build(),
                Activity.builder().name("test2").user(user).build());
        when(activityRepository.findByUserId(USER_ID)).thenReturn(activityList);

        // when
        resumeService.findActivity(USER_ID);

        // then
        verify(activityRepository).findByUserId(USER_ID);
    }

    @Test
    @DisplayName("should find all awards")
    void findAwards() {
        // given
        List<Awards> awardsList = Arrays.asList(
                Awards.builder().name("test1").user(user).build(),
                Awards.builder().name("test2").user(user).build());
        when(awardsRepository.findByUserId(USER_ID)).thenReturn(awardsList);

        // when
        resumeService.findAwards(USER_ID);

        // then
        verify(awardsRepository).findByUserId(USER_ID);
    }
    @Test
    @DisplayName("should find all education")
    void findEducation() {
        // given
        Education education = Education.builder().university("test").user(user).build();
        when(educationRepository.findByUserId(USER_ID)).thenReturn(education);

        // when
        resumeService.findEducation(USER_ID);

        // then
        verify(educationRepository).findByUserId(USER_ID);
    }

}
