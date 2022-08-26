package com.hcu.ticketservice.controller;

import com.hcu.common.ApiPath;
import com.hcu.response.IResponseVO;
import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITicketController {
    @GetMapping(ApiPath.TicketCtrl.GET)
    ResponseEntity<IResponseVO> get(@PathVariable("id") String id);

    @PostMapping
    ResponseEntity<IResponseVO> save(@RequestBody CreateTicketVO createTicketVO);

    @PutMapping
    ResponseEntity<IResponseVO> update(@RequestBody UpdateTicketVO updateTicketVO);

    @GetMapping
    ResponseEntity<IResponseVO> getAll(Pageable pageable);
}
