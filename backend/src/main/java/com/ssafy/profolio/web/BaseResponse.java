package com.ssafy.profolio.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    @ApiModelProperty(example="응답코드 - 성공 : SUCCESS, 데이터X : DATA_IS_NULL")
    private BaseResponseCode code;
    @ApiModelProperty(example="메세지 - 성공 : null, 데이터X : 요청하신 데이터는 Null 입니다.")
    private String message;
    @ApiModelProperty(example="응답데이터 - 성공 : 응답데이터, 데이터X : null")
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
