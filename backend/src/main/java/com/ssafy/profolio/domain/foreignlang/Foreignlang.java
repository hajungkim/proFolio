package com.ssafy.profolio.domain.foreignlang;

import com.ssafy.profolio.domain.user.User;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "foreign_lang")
public class Foreignlang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foreign_lang_id")
    private Long id;

    @Column
    private String language;

    @Column
    private String name;

    @Column
    private String score;

    @Column(name = "certified_date")
    private String certifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Foreignlang(String language, String name, String score, String certifiedDate, User user) {
        this.language = language;
        this.name = name;
        this.score = score;
        this.certifiedDate = certifiedDate;
        this.user = user;
    }

    public void updateForeignLang(ResumeDto.ForeignLangRequest request) {
        this.language = request.getLanguage();
        this.name = request.getName();
        this.score = request.getScore();
        this.certifiedDate = request.getCertifiedDate();
    }
}
