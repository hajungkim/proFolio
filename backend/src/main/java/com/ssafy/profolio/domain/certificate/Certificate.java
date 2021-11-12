package com.ssafy.profolio.domain.certificate;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
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

    @Column(nullable = false)
    private String name;

    @Column(name = "certified_date", nullable = false)
    private String certifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Certificate(String name, String certifiedDate, User user) {
        this.name = name;
        this.certifiedDate = certifiedDate;
        this.user = user;
    }

    public void updateCertificate(ResumeDto.CertificateRequest request) {
        this.name = request.getName();
        this.certifiedDate = request.getCertifiedDate();
    }
}
