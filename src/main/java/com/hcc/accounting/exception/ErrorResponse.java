package com.hcc.accounting.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int statusCode;
    private String message;

    private ServiceException.ErrorType errorType;

    private BizErrorCode errorCode;
}
