package com.hcu.service;

import com.hcu.dto.AccountVO;

public interface IAccountServiceBroker {
    AccountVO getById(String id);
}
