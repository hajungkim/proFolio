package com.ssafy.profolio.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    // 성공일 경우 응답
    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    // 예외처리할 경우 응답
    public BaseResponse(BaseResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
