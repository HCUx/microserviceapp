package com.hcu.accountservice.controller;

import com.hcu.response.IResponseVO;
import com.hcu.response.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public abstract class BaseController {
    public ResponseEntity<IResponseVO> badRequest(String message, int responseCode) {
        return getErrorResponseVO(message, null, responseCode);
    }

    public <T> ResponseEntity<IResponseVO> badRequest(String message, T data, int responseCode) {
        return getErrorResponseVO(message, data, responseCode);
    }

    public <T> ResponseEntity<IResponseVO> ok(String message) {
        return getResponseVO(message, null, 200);
    }

    public <T> ResponseEntity<IResponseVO> ok(String message, IResponseVO data) {
        return getResponseVO(message, data, 200);
    }

    public <T> ResponseEntity<IResponseVO> ok(String message, T data) {
        return getResponseVO(message, data, 200);
    }

    public <T> ResponseEntity<IResponseVO> ok(IResponseVO data) {
        return getResponseVO(data);
    }

    private <T> ResponseEntity<IResponseVO> getResponseVO(String message, T data, int responseCode, HttpStatus httpStatus) {
        IResponseVO response = new ResponseVO();
        response.setResult(data);
        response.setResMessage(message);
        response.setResCode(responseCode);
        return new ResponseEntity<>(response, httpStatus);
    }

    private <T> ResponseEntity<IResponseVO> getResponseVO(String message, T data, int responseCode) {
        IResponseVO response = new ResponseVO();
        response.setResult(data);
        response.setResMessage(message);
        response.setResCode(responseCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private <T> ResponseEntity<IResponseVO> getResponseVO(IResponseVO data) {
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    public <T> ResponseEntity<IResponseVO> getIResponseVOResponseEntity(T data) {
        if (Objects.nonNull(data)) {
            return ok("success", data);
        } else {
            return badRequest("fail", 400);
        }
    }

    private <T> ResponseEntity<IResponseVO> getErrorResponseVO(String message, T data, int responseCode) {
        IResponseVO response = new ResponseVO();
        response.setResult(data);
        response.setResMessage(message);
        response.setResCode(responseCode);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
