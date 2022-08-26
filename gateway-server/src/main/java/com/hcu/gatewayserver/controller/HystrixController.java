package com.hcu.gatewayserver.controller;

import com.hcu.gatewayserver.common.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.HystrixCtrl.BASE)
public class HystrixController {
    @GetMapping(ApiPath.HystrixCtrl.ACCOUNT)
    public String accountFallback() {
        return "Account Service is not available.";
    }

    @GetMapping(ApiPath.HystrixCtrl.TICKET)
    public String ticketFallback() {
        return "Ticket Service is not available.";
    }
}
