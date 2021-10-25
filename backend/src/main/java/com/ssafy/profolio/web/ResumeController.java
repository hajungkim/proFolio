package com.ssafy.profolio.web;

import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.ResumeService;
import com.ssafy.profolio.web.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequiredArgsConstructor
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/activity/{id}")
    public BaseResponse<List<ResumeDto.ActivityResponse>> findActivity(@PathVariable("id") Long userId) {
        List<ResumeDto.ActivityResponse> responseList = resumeService.findActivity(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/awards/{id}")
    public BaseResponse<List<ResumeDto.AwardsResponse>> findAwards(@PathVariable("id") Long userId) {
        List<ResumeDto.AwardsResponse> responseList = resumeService.findAwards(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/career/{id}")
    public BaseResponse<List<ResumeDto.CareerResponse>> findCareer(@PathVariable("id") Long userId) {
        List<ResumeDto.CareerResponse> responseList = resumeService.findCareer(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/certificate/{id}")
    public BaseResponse<List<ResumeDto.CertificateResponse>> findCertificate(@PathVariable("id") Long userId) {
        List<ResumeDto.CertificateResponse> responseList = resumeService.findCertificate(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/foreign/{id}")
    public BaseResponse<List<ResumeDto.ForeignLangResponse>> findForeignLang(@PathVariable("id") Long userId) {
        List<ResumeDto.ForeignLangResponse> responseList = resumeService.findForeignLang(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/project/{id}")
    public BaseResponse<List<ResumeDto.ProjectResponse>> findProject(@PathVariable("id") Long userId) {
        List<ResumeDto.ProjectResponse> responseList = resumeService.findProject(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/technology/{id}")
    public BaseResponse<List<ResumeDto.TechnologyStackResponse>> findTechnologyStack(@PathVariable("id") Long userId) {
        List<ResumeDto.TechnologyStackResponse> responseList = resumeService.findTechnologyStack(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/education/{id}")
    public BaseResponse<ResumeDto.EducationResponse> findEducation(@PathVariable("id") Long userId) {
        ResumeDto.EducationResponse response = resumeService.findEducation(userId);
        return new BaseResponse<>(response);
    }

}
