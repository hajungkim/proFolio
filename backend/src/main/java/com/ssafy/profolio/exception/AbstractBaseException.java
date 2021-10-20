package com.ssafy.profolio.exception;

import com.ssafy.profolio.web.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException {

    private static final long serialVersionUID = 8342235231880246631L;

    protected BaseResponseCode responseCode;
    protected Object[] args;

    public AbstractBaseException() {}

    public AbstractBaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponseCode getResponseCode() {
        return responseCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
