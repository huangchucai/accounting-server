package com.hcc.accounting.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 错误处理
     * @param ex ServiceException
     * @return ResponseEntity
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                             .body(ErrorResponse.builder()
                                                .statusCode(ex.getStatusCode())
                                                .errorCode(ex.getErrorCode())
                                                .message(ex.getMessage())
                                                .errorType(ex.getErrorType())
                                                .build());
    }
    //    @ExceptionHandler(InValidParameterException.class)
    //    public ResponseEntity<ErrorResponse> handleInvalidParameterException(InValidParameterException ex) {
    //        return ResponseEntity.badRequest()
    //                             .body(ErrorResponse.builder()
    //                                                .statusCode(HttpStatus.BAD_REQUEST.value())
    //                                                .errorCode(BizErrorCode.INVALID_PARAMETER)
    //                                                .message("用户id不能小于0")
    //                                                .errorType(ServiceException.ErrorType.CLIENT_ERROR)
    //                                                .build());
    //
    //    }
    //
    //    @ExceptionHandler(ResourceNotFoundException.class)
    //    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //                             .body(ErrorResponse.builder()
    //                                                .statusCode(HttpStatus.NOT_FOUND.value())
    //                                                .errorCode(BizErrorCode.NOT_FOUND)
    //                                                .message(ex.getMessage())
    //                                                .errorType(ServiceException.ErrorType.CLIENT_ERROR)
    //                                                .build());
    //    }
}
