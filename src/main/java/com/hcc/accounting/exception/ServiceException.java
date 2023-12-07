package com.hcc.accounting.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {
    private int statusCode;

    private BizErrorCode errorCode;

    private ErrorType errorType;

    public enum ErrorType {
        CLIENT_ERROR, SERVER_ERROR, UNKNOWN_ERROR
    }

    private String requestId;


    public ServiceException(String message) {
        super(message);
    }
}
