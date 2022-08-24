package com.hcu.accountservice.controller.impl;

import com.hcu.accountservice.common.ApiPath;
import com.hcu.accountservice.controller.IAccountController;
import com.hcu.accountservice.service.impl.AccountService;
import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPath.AccountCtrl.BASE)
@RequiredArgsConstructor
public class AccountController implements IAccountController {

    private final AccountService accountService;

    @Override
    @GetMapping(ApiPath.AccountCtrl.GET)
    public ResponseEntity<AccountVO> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<AccountVO> save(CreateAccountVO createAccountVO) {
        return ResponseEntity.ok(accountService.save(createAccountVO));
    }

    @Override
    @PutMapping
    public ResponseEntity<AccountVO> update(UpdateAccountVO updateAccountVO) {
        return ResponseEntity.ok(accountService.update(updateAccountVO));
    }

    @Override
    @DeleteMapping(ApiPath.AccountCtrl.DELETE)
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
    }
}
