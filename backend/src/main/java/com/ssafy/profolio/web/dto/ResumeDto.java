package com.ssafy.profolio.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ResumeDto {

    @Getter
    @AllArgsConstructor
    public static class ActivityResponse {
        private Long id;
        private String name;
        private String organization;
        private String startDate;
        private String endDate;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class AwardsResponse {
        private Long id;
        private String name;
        private String prize;
        private String description;
        private String awardsDate;
    }

    @Getter
    @AllArgsConstructor
    public static class CareerResponse {
        private Long id;
        private String company;
        private String duty;
        private String startDate;
        private String endDate;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class CertificateResponse {
        private Long id;
        private String name;
        private String certifiedDate;
    }

    @Getter
    @AllArgsConstructor
    public static class EducationResponse {
        private Long id;
        private String university;
        private boolean mainSchool;
        private String major;
        private String minor;
        private String admissionDate;
        private String graduationDate;
        private boolean graduation;
        private String score;
        private Long totalScore;
    }

    @Getter
    @AllArgsConstructor
    public static class ForeignLangResponse {
        private Long id;
        private String language;
        private String name;
        private String score;
        private String certifiedDate;
    }

    @Getter
    @AllArgsConstructor
    public static class ProjectResponse {
        private Long id;
        private String title;
        private String summary;
        private String description;
        private Integer memberCnt;
        private String technologyStack;
        private String role;
        private String link;
        private String startDate;
        private String endDate;
    }

    @Getter
    @AllArgsConstructor
    public static class TechnologyStackResponse {
        private Long id;
        private String name;
        private String level;
        private int kind;
    }

    @Getter
    @AllArgsConstructor
    public static class ActivityRequest {
        private String name;
        private String organization;
        private String startDate;
        private String endDate;
        private String description;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class AwardsRequest {
        private String name;
        private String prize;
        private String description;
        private String awardsDate;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class CareerRequest {
        private String company;
        private String duty;
        private String startDate;
        private String endDate;
        private String description;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class CertificateRequest {
        private String name;
        private String certifiedDate;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class EducationRequest {
        private String university;
        private boolean mainSchool;
        private String major;
        private String minor;
        private String admissionDate;
        private String graduationDate;
        private boolean graduation;
        private String score;
        private Long totalScore;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class ForeignLangRequest {
        private String language;
        private String name;
        private String score;
        private String certifiedDate;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class ProjectRequest {
        private String title;
        private String summary;
        private String description;
        private Integer memberCnt;
        private String technologyStack;
        private String role;
        private String link;
        private String startDate;
        private String endDate;
        private Long userId;
    }

    @Getter
    @AllArgsConstructor
    public static class TechnologyStackRequest {
        private String name;
        private String level;
        private int kind;
        private Long userId;
    }
}
