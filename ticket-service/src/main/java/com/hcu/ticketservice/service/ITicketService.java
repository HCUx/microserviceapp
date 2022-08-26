package com.hcu.ticketservice.service;

import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.TicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    TicketVO save(CreateTicketVO createTicketVO);

    TicketVO update(UpdateTicketVO updateTicketVO);

    TicketVO getById(String id);

    List<TicketVO> getAll(Pageable pageable);
}
