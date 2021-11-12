package com.ssafy.profolio.web;

import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.ResumeService;
import com.ssafy.profolio.web.dto.ResumeDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequiredArgsConstructor
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @ApiOperation(value = "활동 목록 조회", notes = "활동 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/activity/{userid}")
    public BaseResponse<List<ResumeDto.ActivityResponse>> findActivity(@PathVariable("userid") Long userId) {
        List<ResumeDto.ActivityResponse> responseList = resumeService.findActivity(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "수상 목록 조회", notes = "수상 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/awards/{userid}")
    public BaseResponse<List<ResumeDto.AwardsResponse>> findAwards(@PathVariable("userid") Long userId) {
        List<ResumeDto.AwardsResponse> responseList = resumeService.findAwards(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "경력 목록 조회", notes = "경력 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/career/{userid}")
    public BaseResponse<List<ResumeDto.CareerResponse>> findCareer(@PathVariable("userid") Long userId) {
        List<ResumeDto.CareerResponse> responseList = resumeService.findCareer(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "자격증 목록 조회", notes = "자격증 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/certificate/{userid}")
    public BaseResponse<List<ResumeDto.CertificateResponse>> findCertificate(@PathVariable("userid") Long userId) {
        List<ResumeDto.CertificateResponse> responseList = resumeService.findCertificate(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "외국어 목록 조회", notes = "외국어 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/foreign/{userid}")
    public BaseResponse<List<ResumeDto.ForeignLangResponse>> findForeignLang(@PathVariable("userid") Long userId) {
        List<ResumeDto.ForeignLangResponse> responseList = resumeService.findForeignLang(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "프로젝트 목록 조회", notes = "프로젝트 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/project/{userid}")
    public BaseResponse<List<ResumeDto.ProjectResponse>> findProject(@PathVariable("userid") Long userId) {
        List<ResumeDto.ProjectResponse> responseList = resumeService.findProject(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "기술스택 목록 조회", notes = "기술스택 데이터 있으면 리스트 반환, 없으면 null 반환")
    @GetMapping("/technology/{userid}")
    public BaseResponse<List<ResumeDto.TechnologyStackResponse>> findTechnologyStack(@PathVariable("userid") Long userId) {
        List<ResumeDto.TechnologyStackResponse> responseList = resumeService.findTechnologyStack(userId);
        if (responseList.size() == 0) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<>(responseList);
    }

    @ApiOperation(value = "학력 목록 조회", notes = "학력 데이터 있으면 반환, 없으면 null 반환")
    @GetMapping("/education/{userid}")
    public BaseResponse<ResumeDto.EducationResponse> findEducation(@PathVariable("userid") Long userId) {
        ResumeDto.EducationResponse response = resumeService.findEducation(userId);
        return new BaseResponse<>(response);
    }

    @ApiOperation(value = "활동 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/activity")
    public BaseResponse<Boolean> saveActivity(@RequestBody ResumeDto.ActivityRequest request) {
        resumeService.saveActivity(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "수상 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/awards")
    public BaseResponse<Boolean> saveAwards(@RequestBody ResumeDto.AwardsRequest request) {
        resumeService.saveAwards(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "경력 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/career")
    public BaseResponse<Boolean> saveCareer(@RequestBody ResumeDto.CareerRequest request) {
        resumeService.saveCareer(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "자격증 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/certificate")
    public BaseResponse<Boolean> saveCertificate(@RequestBody ResumeDto.CertificateRequest request) {
        resumeService.saveCertificate(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "학력 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/education")
    public BaseResponse<Boolean> saveEducation(@RequestBody ResumeDto.EducationRequest request) {
        resumeService.saveEducation(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "외국어 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/foreign")
    public BaseResponse<Boolean> saveForeignLang(@RequestBody ResumeDto.ForeignLangRequest request) {
        resumeService.saveForeignLang(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "프로젝트 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/project")
    public BaseResponse<Boolean> saveProject(@RequestBody ResumeDto.ProjectRequest request) {
        resumeService.saveProject(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "기술스택 등록", notes = "데이터 저장 성공 시 true 반환")
    @PostMapping("/technology")
    public BaseResponse<Boolean> saveTechnologyStack(@RequestBody ResumeDto.TechnologyStackRequest request) {
        resumeService.saveTechnologyStack(request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "활동 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/activity/{id}")
    public BaseResponse<Boolean> updateActivity(@PathVariable Long id, @RequestBody ResumeDto.ActivityRequest request) {
        resumeService.updateActivity(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "수상 수정", notes = "데이터 수정 성공 시 '수정 완료' 반환")
    @PutMapping("/awards/{id}")
    public BaseResponse<Boolean> updateAwards(@PathVariable Long id, @RequestBody ResumeDto.AwardsRequest request) {
        resumeService.updateAwards(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "경력 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/career/{id}")
    public BaseResponse<Boolean> updateCareer(@PathVariable Long id, @RequestBody ResumeDto.CareerRequest request) {
        resumeService.updateCareer(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "자격증 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/certificate/{id}")
    public BaseResponse<Boolean> updateCertificate(@PathVariable Long id, @RequestBody ResumeDto.CertificateRequest request) {
        resumeService.updateCertificate(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "학력 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/education/{userid}")
    public BaseResponse<Boolean> updateEducation(@PathVariable("userid") Long userId, @RequestBody ResumeDto.EducationRequest request) {
        resumeService.updateEducation(userId, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "외국어 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/foreign/{id}")
    public BaseResponse<Boolean> updateForeignLang(@PathVariable Long id, @RequestBody ResumeDto.ForeignLangRequest request) {
        resumeService.updateForeignLang(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "프로젝트 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/project/{id}")
    public BaseResponse<Boolean> updateProject(@PathVariable Long id, @RequestBody ResumeDto.ProjectRequest request) {
        resumeService.updateProject(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "기술스택 수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/technology/{id}")
    public BaseResponse<Boolean> updateTechnologyStack(@PathVariable Long id, @RequestBody ResumeDto.TechnologyStackRequest request) {
        resumeService.updateTechnologyStack(id, request);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "활동 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/activity/{id}")
    public BaseResponse<Boolean> deleteActivity(@PathVariable Long id) {
        resumeService.deleteActivity(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "수상 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/awards/{id}")
    public BaseResponse<Boolean> deleteAwards(@PathVariable Long id) {
        resumeService.deleteAwards(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "경력 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/career/{id}")
    public BaseResponse<Boolean> deleteCareer(@PathVariable Long id) {
        resumeService.deleteCareer(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "자격증 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/certificate/{id}")
    public BaseResponse<Boolean> deleteCertificate(@PathVariable Long id) {
        resumeService.deleteCertificate(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "학력 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/education/{id}")
    public BaseResponse<Boolean> deleteEducation(@PathVariable Long id) {
        resumeService.deleteEducation(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "외국어 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/foreign/{id}")
    public BaseResponse<Boolean> deleteForeignLang(@PathVariable Long id) {
        resumeService.deleteForeignLang(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "프로젝트 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/project/{id}")
    public BaseResponse<Boolean> deleteProject(@PathVariable Long id) {
        resumeService.deleteProject(id);
        return new BaseResponse<>(true);
    }

    @ApiOperation(value = "기술스택 삭제", notes = "데이터 삭제 성공 시 true 반환")
    @DeleteMapping("/technology/{id}")
    public BaseResponse<Boolean> deleteTechnologyStack(@PathVariable Long id) {
        resumeService.deleteTechnologyStack(id);
        return new BaseResponse<>(true);
    }

}
