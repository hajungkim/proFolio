package com.ssafy.profolio.web;

import com.ssafy.profolio.exception.BaseException;
import com.ssafy.profolio.service.UserService;
import com.ssafy.profolio.web.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/test")
//    public BaseResponse<String> testController() {
//        String res = "응답데이터";
//        if (res == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
//        return new BaseResponse<String>(res);
//    }

    @ApiOperation(value = "유저 기본 정보 조회", notes = "데이터 조회 성공 시 데이터 반환")
    @GetMapping("/{userid}")
    public BaseResponse<UserDto.UserResponse> findUserInfo(@PathVariable("userid") Long userId){
        UserDto.UserResponse response = userService.findUser(userId);
        return new BaseResponse<>(response);
    }

    @ApiOperation(value = "유저 기본 정보   수정", notes = "데이터 수정 성공 시 true 반환")
    @PutMapping("/{userid}")
    public BaseResponse<Boolean> updateUserInfo(@PathVariable("userid") Long userId, @RequestBody UserDto.UserRequest request){
        userService.updateUser(userId, request);
        return new BaseResponse<>(true);
    }


}
