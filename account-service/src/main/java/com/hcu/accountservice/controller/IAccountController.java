package com.hcu.accountservice.controller;

import com.hcu.accountservice.common.ApiPath;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import com.hcu.accountservice.vo.response.IResponseVO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountController {
    @GetMapping(ApiPath.AccountCtrl.GET)
    ResponseEntity<IResponseVO> get(@PathVariable("id") String id);

    @PostMapping
    ResponseEntity<IResponseVO> save(@RequestBody CreateAccountVO createAccountVO);

    @PutMapping
    ResponseEntity<IResponseVO> update(@RequestBody UpdateAccountVO updateAccountVO);

    @DeleteMapping
    void delete(@PathVariable("id") String id);

    @GetMapping
    ResponseEntity<IResponseVO> getAll(Pageable pageable);
}
