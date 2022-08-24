package com.hcu.accountservice.controller.impl;

import com.hcu.accountservice.common.ApiPath;
import com.hcu.accountservice.constant.ResponseMessage;
import com.hcu.accountservice.controller.BaseController;
import com.hcu.accountservice.controller.IAccountController;
import com.hcu.accountservice.service.impl.AccountService;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import com.hcu.accountservice.vo.response.IResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPath.AccountCtrl.BASE)
@RequiredArgsConstructor
public class AccountController extends BaseController implements IAccountController {

    private final AccountService accountService;

    @Override
    public ResponseEntity<IResponseVO> get(String id) {
        return ok(ResponseMessage.SUCCESS, accountService.get(id));
    }

    @Override
    public ResponseEntity<IResponseVO> save(CreateAccountVO createAccountVO) {
        return ok(ResponseMessage.SUCCESS, accountService.save(createAccountVO));
    }

    @Override
    public ResponseEntity<IResponseVO> update(UpdateAccountVO updateAccountVO) {
        return ok(ResponseMessage.SUCCESS, accountService.update(updateAccountVO));
    }

    @Override
    public void delete(String id) {
        accountService.delete(id);
    }

    @Override
    public ResponseEntity<IResponseVO> getAll(Pageable pageable) {
        return ok(ResponseMessage.SUCCESS, accountService.getAll(pageable));
    }
}
