package com.hcc.accounting.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ServiceException {
    /**
     * 资源不存在报错
     * @param message 信息
     */
    public ResourceNotFoundException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setErrorCode(BizErrorCode.INVALID_PARAMETER);
        this.setErrorType(ErrorType.CLIENT_ERROR);
    }
}
