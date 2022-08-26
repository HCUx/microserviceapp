package com.hcu.ticketservice.controller.impl;

import com.hcu.common.ApiPath;
import com.hcu.response.IResponseVO;
import com.hcu.ticketservice.constant.ResponseMessage;
import com.hcu.ticketservice.controller.BaseController;
import com.hcu.ticketservice.controller.ITicketController;
import com.hcu.ticketservice.service.ITicketService;
import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPath.TicketCtrl.BASE)
@RequiredArgsConstructor
public class TicketController extends BaseController implements ITicketController {
    private final ITicketService ticketService;

    @Override
    public ResponseEntity<IResponseVO> get(String id) {
        return ok(ResponseMessage.SUCCESS, ticketService.getById(id));
    }

    @Override
    public ResponseEntity<IResponseVO> save(CreateTicketVO createTicketVO) {
        return ok(ResponseMessage.SUCCESS, ticketService.save(createTicketVO));
    }

    @Override
    public ResponseEntity<IResponseVO> update(UpdateTicketVO updateTicketVO) {
        return ok(ResponseMessage.SUCCESS, ticketService.update(updateTicketVO));
    }

    @Override
    public ResponseEntity<IResponseVO> getAll(Pageable pageable) {
        return ok(ResponseMessage.SUCCESS, ticketService.getAll(pageable));
    }
}
