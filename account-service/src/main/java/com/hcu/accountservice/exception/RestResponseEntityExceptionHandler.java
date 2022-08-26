package com.hcu.accountservice.exception;

import com.hcu.response.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountServiceException.class)
    protected ResponseEntity<?> handleAccountServiceException(AccountServiceException ex, WebRequest webRequest) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ResponseVO responseVO = new ResponseVO(errors, "error", 500);
        log.error("{} {}", webRequest.getDescription(true), errors);
        return new ResponseEntity<>(responseVO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleConflict(Exception ex, WebRequest webRequest) {
        List<String> errors = new ArrayList<>();
        errors.add("An error occurred.");
        ResponseVO responseVO = new ResponseVO(errors, "error", 500);
        log.error("{} {}", webRequest.getDescription(true), errors);
        return new ResponseEntity<>(responseVO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
