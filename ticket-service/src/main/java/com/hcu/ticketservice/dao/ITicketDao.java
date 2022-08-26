package com.hcu.ticketservice.dao;

import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.TicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketDao {
    TicketVO save(CreateTicketVO createTicketVO);

    TicketVO update(UpdateTicketVO updateTicketVO);

    TicketVO getById(String id);

    List<TicketVO> getAll(Pageable pageable);
}
