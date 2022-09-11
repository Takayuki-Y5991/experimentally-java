package com.example.javautilslibrary.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiErrorResponse> handleAuthException(AccessDeniedException ex) {
        return errorLogging(ex, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({Exception.class, ClientException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        return errorLogging(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({DomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(Exception ex) {
        return errorLogging(ex, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handlerNotFound(Exception ex) {
        return errorLogging(ex, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiErrorResponse> handlerUnauthorized(Exception ex) {
        return errorLogging(ex, HttpStatus.UNAUTHORIZED);
    }


    private ResponseEntity<ApiErrorResponse> errorLogging(Exception ex, HttpStatus status) {
        log.error("[Error]: [" + ex.getMessage() + "]");
        log.error("[Cause]: [" + ex.getCause().getStackTrace() + "]");
        return new ResponseEntity<ApiErrorResponse>(ApiErrorResponse.build(status.value(), ex.getMessage()), status);
    }

    /**
     * @param ex      the exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.build(status.value(), ex.getMessage()), status);
    }
}
