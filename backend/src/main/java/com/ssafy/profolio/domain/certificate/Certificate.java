package com.ssafy.profolio.domain.certificate;

import com.ssafy.profolio.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String organization;

    @Column(name = "certified_date")
    private String certifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Certificate(String name, String organization, String certifiedDate, User user) {
        this.name = name;
        this.organization = organization;
        this.certifiedDate = certifiedDate;
        this.user = user;
    }
}
