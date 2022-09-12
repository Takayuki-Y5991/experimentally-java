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

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiErrorResponse> handleAuthException(AccessDeniedException ex) {
        this.errorLogging(ex, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(ApiErrorResponse.build(HttpStatus.FORBIDDEN.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({Exception.class, ClientException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        this.errorLogging(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(ApiErrorResponse.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({DomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(Exception ex) {
        this.errorLogging(ex, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ApiErrorResponse>(ApiErrorResponse.build(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handlerNotFound(Exception ex) {
        this.errorLogging(ex, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ApiErrorResponse.build(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiErrorResponse> handlerUnauthorized(Exception ex) {
        this.errorLogging(ex, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(ApiErrorResponse.build(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }


    private void errorLogging(Exception ex, HttpStatus status) {
        log.error("[Error]: [" + ex.getMessage() + "]");
        if (Objects.nonNull(ex.getCause())) {
            log.error("[Cause]: [" + ex.getCause().getStackTrace() + "]");
        }
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
