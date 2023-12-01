package com.hcc.accounting.exception;

import org.springframework.http.HttpStatus;

public class InValidParameterException extends ServiceException {

    public InValidParameterException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setErrorCode(BizErrorCode.INVALID_PARAMETER);
        this.setErrorType(ErrorType.CLIENT_ERROR);
    }
}
