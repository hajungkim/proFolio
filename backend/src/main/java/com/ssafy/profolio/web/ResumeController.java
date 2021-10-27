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

    @GetMapping("/activity/{userid}")
    public BaseResponse<List<ResumeDto.ActivityResponse>> findActivity(@PathVariable("userid") Long userId) {
        List<ResumeDto.ActivityResponse> responseList = resumeService.findActivity(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/awards/{userid}")
    public BaseResponse<List<ResumeDto.AwardsResponse>> findAwards(@PathVariable("userid") Long userId) {
        List<ResumeDto.AwardsResponse> responseList = resumeService.findAwards(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/career/{userid}")
    public BaseResponse<List<ResumeDto.CareerResponse>> findCareer(@PathVariable("userid") Long userId) {
        List<ResumeDto.CareerResponse> responseList = resumeService.findCareer(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/certificate/{userid}")
    public BaseResponse<List<ResumeDto.CertificateResponse>> findCertificate(@PathVariable("userid") Long userId) {
        List<ResumeDto.CertificateResponse> responseList = resumeService.findCertificate(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/foreign/{userid}")
    public BaseResponse<List<ResumeDto.ForeignLangResponse>> findForeignLang(@PathVariable("userid") Long userId) {
        List<ResumeDto.ForeignLangResponse> responseList = resumeService.findForeignLang(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/project/{userid}")
    public BaseResponse<List<ResumeDto.ProjectResponse>> findProject(@PathVariable("userid") Long userId) {
        List<ResumeDto.ProjectResponse> responseList = resumeService.findProject(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/technology/{userid}")
    public BaseResponse<List<ResumeDto.TechnologyStackResponse>> findTechnologyStack(@PathVariable("userid") Long userId) {
        List<ResumeDto.TechnologyStackResponse> responseList = resumeService.findTechnologyStack(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @GetMapping("/education/{userid}")
    public BaseResponse<ResumeDto.EducationResponse> findEducation(@PathVariable("userid") Long userId) {
        ResumeDto.EducationResponse response = resumeService.findEducation(userId);
        return new BaseResponse<>(response);
    }

    @PostMapping("/activity")
    public BaseResponse<String> saveActivity(@RequestBody ResumeDto.ActivityRequest request) {
        resumeService.saveActivity(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/awards")
    public BaseResponse<String> saveAwards(@RequestBody ResumeDto.AwardsRequest request) {
        resumeService.saveAwards(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/career")
    public BaseResponse<String> saveCareer(@RequestBody ResumeDto.CareerRequest request) {
        resumeService.saveCareer(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/certificate")
    public BaseResponse<String> saveCertificate(@RequestBody ResumeDto.CertificateRequest request) {
        resumeService.saveCertificate(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/education")
    public BaseResponse<String> saveEducation(@RequestBody ResumeDto.EducationRequest request) {
        resumeService.saveEducation(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/foreign")
    public BaseResponse<String> saveForeignLang(@RequestBody ResumeDto.ForeignLangRequest request) {
        resumeService.saveForeignLang(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/project")
    public BaseResponse<String> saveProject(@RequestBody ResumeDto.ProjectRequest request) {
        resumeService.saveProject(request);
        return new BaseResponse<>("저장 완료");
    }

    @PostMapping("/technology")
    public BaseResponse<String> saveTechnologyStack(@RequestBody ResumeDto.TechnologyStackRequest request) {
        resumeService.saveTechnologyStack(request);
        return new BaseResponse<>("저장 완료");
    }

    @PutMapping("/activity/{id}")
    public BaseResponse<String> updateActivity(@PathVariable Long id, @RequestBody ResumeDto.ActivityRequest request) {
        resumeService.updateActivity(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/awards/{id}")
    public BaseResponse<String> updateAwards(@PathVariable Long id, @RequestBody ResumeDto.AwardsRequest request) {
        resumeService.updateAwards(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/career/{id}")
    public BaseResponse<String> updateCareer(@PathVariable Long id, @RequestBody ResumeDto.CareerRequest request) {
        resumeService.updateCareer(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/certificate/{id}")
    public BaseResponse<String> updateCertificate(@PathVariable Long id, @RequestBody ResumeDto.CertificateRequest request) {
        resumeService.updateCertificate(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/education/{id}")
    public BaseResponse<String> updateEducation(@PathVariable Long id, @RequestBody ResumeDto.EducationRequest request) {
        resumeService.updateEducation(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/foreign/{id}")
    public BaseResponse<String> updateForeignLang(@PathVariable Long id, @RequestBody ResumeDto.ForeignLangRequest request) {
        resumeService.updateForeignLang(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/project/{id}")
    public BaseResponse<String> updateProject(@PathVariable Long id, @RequestBody ResumeDto.ProjectRequest request) {
        resumeService.updateProject(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @PutMapping("/technology/{id}")
    public BaseResponse<String> updateTechnologyStack(@PathVariable Long id, @RequestBody ResumeDto.TechnologyStackRequest request) {
        resumeService.updateTechnologyStack(id, request);
        return new BaseResponse<>("수정 완료");
    }

    @DeleteMapping("/activity/{id}")
    public BaseResponse<String> deleteActivity(@PathVariable Long id) {
        resumeService.deleteActivity(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/awards/{id}")
    public BaseResponse<String> deleteAwards(@PathVariable Long id) {
        resumeService.deleteAwards(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/career/{id}")
    public BaseResponse<String> deleteCareer(@PathVariable Long id) {
        resumeService.deleteCareer(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/certificate/{id}")
    public BaseResponse<String> deleteCertificate(@PathVariable Long id) {
        resumeService.deleteCertificate(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/education/{id}")
    public BaseResponse<String> deleteEducation(@PathVariable Long id) {
        resumeService.deleteEducation(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/foreign/{id}")
    public BaseResponse<String> deleteForeignLang(@PathVariable Long id) {
        resumeService.deleteForeignLang(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/project/{id}")
    public BaseResponse<String> deleteProject(@PathVariable Long id) {
        resumeService.deleteProject(id);
        return new BaseResponse<>("삭제 완료");
    }

    @DeleteMapping("/technology/{id}")
    public BaseResponse<String> deleteTechnologyStack(@PathVariable Long id) {
        resumeService.deleteTechnologyStack(id);
        return new BaseResponse<>("삭제 완료");
    }

}
