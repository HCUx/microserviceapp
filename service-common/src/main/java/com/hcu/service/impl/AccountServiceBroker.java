package com.hcu.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.client.AccountServiceClient;
import com.hcu.dto.AccountVO;
import com.hcu.response.ResponseVO;
import com.hcu.service.IAccountServiceBroker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceBroker implements IAccountServiceBroker {
    private final AccountServiceClient accountServiceClient;
    private final ObjectMapper objectMapper;

    @Override
    public AccountVO getById(String id) {
        log.info("Request sending with feign");
        ResponseVO<Object> responseVO = accountServiceClient.get(id);
        log.info("Response accepted");
        if (Objects.nonNull(responseVO)) {
            try {
                return objectMapper.convertValue(responseVO.getResult(), AccountVO.class);
            } catch (Exception ex) {
                log.error("Response Type is not Account. {}", responseVO.getResult());
                throw new RuntimeException("Account Service Response is null.");
            }
        }
        log.error("Response is null");
        throw new RuntimeException("Account Service Response is null.");
    }

}
