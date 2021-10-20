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

    public BaseResponse(T data, String message) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }
}
