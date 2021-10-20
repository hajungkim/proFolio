package com.ssafy.profolio.web;

import com.ssafy.profolio.exception.BaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/test")
    public BaseResponse<String> testController() {
        String res = "응답데이터";
        if (res == null) throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        return new BaseResponse<String>(res);
    }
}
