package com.ssafy.profolio.domain.career;

import com.ssafy.profolio.domain.user.User;
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

    @Column
    private String company;

    @Column
    private String duty;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(length = 500)
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
}
