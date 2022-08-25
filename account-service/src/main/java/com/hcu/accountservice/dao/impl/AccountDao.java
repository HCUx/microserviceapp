package com.hcu.accountservice.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.accountservice.constant.ResponseMessage;
import com.hcu.accountservice.dao.IAccountDao;
import com.hcu.accountservice.entity.Account;
import com.hcu.accountservice.exception.AccountServiceException;
import com.hcu.accountservice.repository.AccountRepository;
import com.hcu.accountservice.util.IMapperUtil;
import com.hcu.accountservice.vo.AccountVO;
import com.hcu.accountservice.vo.CreateAccountVO;
import com.hcu.accountservice.vo.UpdateAccountVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountDao implements IAccountDao {
    private final AccountRepository accountRepository;

    private final ObjectMapper objectMapper;

    private final ModelMapper modelMapper;

    private final IMapperUtil mapperUtil;

    @Override
    public AccountVO get(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountServiceException(ResponseMessage.NOT_FOUND));
        return objectMapper.convertValue(account, AccountVO.class);
    }

    @Override
    @Transactional
    public AccountVO save(CreateAccountVO createAccountVO) {
        Account requestAccount = objectMapper.convertValue(createAccountVO, Account.class);
        Account savedAccount = accountRepository.save(requestAccount);
        return objectMapper.convertValue(savedAccount, AccountVO.class);
    }

    @Override
    @Transactional
    public AccountVO update(UpdateAccountVO updateAccountVO) {
        Account account = accountRepository.findById(updateAccountVO.getId())
                .orElseThrow(() -> new AccountServiceException(ResponseMessage.NOT_FOUND));
        //modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updateAccountVO, account);
        account = accountRepository.save(account);
        return objectMapper.convertValue(account, AccountVO.class);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountServiceException(ResponseMessage.NOT_FOUND));
        if (Objects.nonNull(account)) {
            account.setActive(false);
            accountRepository.save(account);
        }
    }

    @Override
    public List<AccountVO> getAll(Pageable pageable) {
        return mapperUtil.mapList(accountRepository.findAll(pageable), AccountVO.class);
    }
}
