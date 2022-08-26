package com.hcu.ticketservice.service.impl;

import com.hcu.dto.AccountVO;
import com.hcu.service.IAccountServiceBroker;
import com.hcu.ticketservice.dao.ITicketDao;
import com.hcu.ticketservice.dao.ITicketESDao;
import com.hcu.ticketservice.service.ITicketNotificationService;
import com.hcu.ticketservice.service.ITicketService;
import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.TicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService {
    private final ITicketDao ticketDao;

    private final ITicketESDao ticketESDao;

    private final IAccountServiceBroker accountServiceBroker;

    private final ITicketNotificationService ticketNotificationService;

    @Override
    @Transactional
    public TicketVO save(CreateTicketVO createTicketVO) {
        AccountVO accountVO = accountServiceBroker.getById(createTicketVO.getAssignee());

        createTicketVO.setAssignee(accountVO.getId());
        TicketVO savedTicket = ticketDao.save(createTicketVO);

        CreateTicketVO createTicketESVO;
        createTicketESVO = createTicketVO;
        createTicketESVO.setAssignee(accountVO.getNameSurname());
        ticketESDao.save(createTicketESVO, savedTicket.getId());

        CompletableFuture.runAsync(() -> ticketNotificationService.sendToQueue(savedTicket));
        return savedTicket;
    }

    @Override
    public TicketVO update(UpdateTicketVO updateTicketVO) {
        TicketVO ticketVO = ticketDao.update(updateTicketVO);
        ticketESDao.update(updateTicketVO);
        return ticketVO;
    }

    @Override
    public TicketVO getById(String id) {
        return ticketDao.getById(id);
    }

    @Override
    public List<TicketVO> getAll(Pageable pageable) {
        return ticketDao.getAll(pageable);
    }
}
