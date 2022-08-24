package com.hcu.accountservice.service.impl;

import com.hcu.accountservice.dao.IAccountDao;
import com.hcu.accountservice.service.IAccountService;
import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountDao accountDao;

    @Override
    public AccountVO get(String id) {
        return accountDao.get(id);
    }

    @Override
    public AccountVO save(CreateAccountVO createAccountVO) {
        return accountDao.save(createAccountVO);
    }

    @Override
    public AccountVO update(UpdateAccountVO account) {
        return accountDao.update(account);
    }

    @Override
    public void delete(String id) {
        accountDao.delete(id);
    }
}
