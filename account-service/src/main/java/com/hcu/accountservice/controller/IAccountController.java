package com.hcu.accountservice.controller;

import com.hcu.accountservice.common.ApiPath;
import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountController {
    @GetMapping(ApiPath.AccountCtrl.GET)
    ResponseEntity<AccountVO> get(@PathVariable("id") String id);

    @PostMapping
    ResponseEntity<AccountVO> save(@RequestBody CreateAccountVO createAccountVO);

    @PutMapping
    ResponseEntity<AccountVO> update(@RequestBody UpdateAccountVO updateAccountVO);

    @DeleteMapping
    void delete(@PathVariable("id") String id);
}
