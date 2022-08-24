package com.hcu.accountservice.dao;

import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;

public interface IAccountDao {
    AccountVO get(String id);

    AccountVO save(CreateAccountVO createAccountVO);

    AccountVO update(UpdateAccountVO account);

    void delete(String id);
}
