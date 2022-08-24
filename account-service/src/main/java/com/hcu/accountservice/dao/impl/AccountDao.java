package com.hcu.accountservice.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.accountservice.dao.IAccountDao;
import com.hcu.accountservice.entity.Account;
import com.hcu.accountservice.repository.AccountRepository;
import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountDao implements IAccountDao {
    private final AccountRepository accountRepository;

    private final ObjectMapper objectMapper;

    public AccountVO get(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        return objectMapper.convertValue(account, AccountVO.class);
    }

    public AccountVO save(CreateAccountVO createAccountVO) {
        Account requestAccount = objectMapper.convertValue(createAccountVO, Account.class);
        Account savedAccount = accountRepository.save(requestAccount);
        return objectMapper.convertValue(savedAccount, AccountVO.class);
    }

    public AccountVO update(UpdateAccountVO updateAccountVO) {
        Account account = accountRepository.findById(updateAccountVO.getId()).orElse(null);
        if (Objects.nonNull(account)) {
            account.setEmail(updateAccountVO.getEmail());
            account.setUserName(updateAccountVO.getUserName());
            account.setPasswd(updateAccountVO.getPasswd());
            account = accountRepository.save(account);
        }
        return objectMapper.convertValue(account, AccountVO.class);
    }

    public void delete(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (Objects.nonNull(account)) {
            account.setActive(false);
            accountRepository.save(account);
        }
    }
}
