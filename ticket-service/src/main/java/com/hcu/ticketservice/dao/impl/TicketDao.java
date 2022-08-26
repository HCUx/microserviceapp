package com.hcu.ticketservice.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.ticketservice.constant.ResponseMessage;
import com.hcu.ticketservice.dao.ITicketDao;
import com.hcu.ticketservice.entity.Ticket;
import com.hcu.ticketservice.exception.TicketServiceException;
import com.hcu.ticketservice.repository.TicketRepository;
import com.hcu.ticketservice.util.IMapperUtil;
import com.hcu.ticketservice.vo.CreateTicketVO;
import com.hcu.ticketservice.vo.TicketVO;
import com.hcu.ticketservice.vo.UpdateTicketVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketDao implements ITicketDao {

    private final TicketRepository ticketRepository;

    private final ObjectMapper objectMapper;

    private final ModelMapper modelMapper;

    private final IMapperUtil mapperUtil;

    @Override
    @Transactional
    public TicketVO save(CreateTicketVO createTicketVO) {
        Ticket requestTicket = objectMapper.convertValue(createTicketVO, Ticket.class);
        Ticket savedTicket = ticketRepository.save(requestTicket);
        return objectMapper.convertValue(savedTicket, TicketVO.class);
    }

    @Override
    @Transactional
    public TicketVO update(UpdateTicketVO updateTicketVO) {
        Ticket ticket = ticketRepository.findById(updateTicketVO.getId())
                .orElseThrow(() -> new TicketServiceException(ResponseMessage.NOT_FOUND));
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updateTicketVO, ticket);
        ticket = ticketRepository.save(ticket);
        return objectMapper.convertValue(ticket, TicketVO.class);
    }

    @Override
    public TicketVO getById(String id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketServiceException(ResponseMessage.NOT_FOUND));
        return objectMapper.convertValue(ticket, TicketVO.class);
    }

    @Override
    public List<TicketVO> getAll(Pageable pageable) {
        return mapperUtil.mapList(ticketRepository.findAll(pageable), TicketVO.class);
    }
}
