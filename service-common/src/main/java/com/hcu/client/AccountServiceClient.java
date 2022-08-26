package com.hcu.client;

import com.hcu.common.ApiPath;
import com.hcu.response.ResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountServiceClient {

    @RequestMapping(path = ApiPath.AccountCtrl.GET_COMBINE)
    ResponseVO<Object> get(@PathVariable("id") String id);
}
