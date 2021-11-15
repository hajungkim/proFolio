package com.ssafy.profolio.domain.career;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrer_id")
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String duty;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date", nullable = false)
    private String endDate;

    @Column(length = 500, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Career(String company, String duty, String startDate, String endDate, String description, User user) {
        this.company = company;
        this.duty = duty;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.user = user;
    }

    public void updateCareer(ResumeDto.CareerRequest request) {
        this.company = request.getCompany();
        this.duty = request.getDuty();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.description = request.getDescription();
    }
}
