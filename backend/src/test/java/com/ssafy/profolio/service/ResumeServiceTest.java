package com.ssafy.profolio.service;

import com.ssafy.profolio.domain.activity.Activity;
import com.ssafy.profolio.domain.activity.ActivityRepository;
import com.ssafy.profolio.domain.awards.AwardsRepository;
import com.ssafy.profolio.domain.career.CareerRepository;
import com.ssafy.profolio.domain.certificate.CertificateRepository;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

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

    @BeforeEach
    public void setUp() {
        resumeService = new ResumeService(userRepository, activityRepository, awardsRepository,careerRepository,
                certificateRepository, educationRepository, foreignlangRepository, projectRepository, technologyStackRepository);
    }

    @Test
    @DisplayName("")
    void saveActivity() {
        // given
        User user = User.builder()
                .accessToken("test")
                .refreshToken("test")
                .socialId("1")
                .email("test")
                .name("test")
                .phone("test")
                .birthday("test")
                .profilePath("test")
                .build();

        Activity activity = Activity.builder()
                .id(1L)
                .name("test")
                .organization("or")
                .startDate("20210101")
                .endDate("20210101")
                .description("test")
                .user(user)
                .build();

        Mockito.when(activityRepository.save(any())).thenReturn(activity);

        // when

        // then
    }
}