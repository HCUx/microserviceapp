package com.hcu.ticketservice.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.ticketservice.constant.ResponseMessage;
import com.hcu.ticketservice.dao.ITicketESDao;
import com.hcu.ticketservice.entity.es.TicketES;
import com.hcu.ticketservice.exception.TicketServiceException;
import com.hcu.ticketservice.repository.es.TicketESRepository;
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
public class TicketESDao implements ITicketESDao {

    private final TicketESRepository ticketESRepository;

    private final ObjectMapper objectMapper;

    private final ModelMapper modelMapper;

    private final IMapperUtil mapperUtil;

    @Override
    @Transactional
    public TicketVO save(CreateTicketVO createTicketVO, String id) {
        TicketES requestTicketES = objectMapper.convertValue(createTicketVO, TicketES.class);
        requestTicketES.setId(id);
        TicketES savedTicketES = ticketESRepository.save(requestTicketES);
        return objectMapper.convertValue(savedTicketES, TicketVO.class);
    }

    @Override
    @Transactional
    public TicketVO update(UpdateTicketVO updateTicketVO) {
        TicketES ticketES = ticketESRepository.findById(updateTicketVO.getId())
                .orElseThrow(() -> new TicketServiceException(ResponseMessage.NOT_FOUND));
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updateTicketVO, ticketES);
        ticketES = ticketESRepository.save(ticketES);
        return objectMapper.convertValue(ticketES, TicketVO.class);
    }

    @Override
    public TicketVO getById(String id) {
        TicketES ticketES = ticketESRepository.findById(id)
                .orElseThrow(() -> new TicketServiceException(ResponseMessage.NOT_FOUND));
        return objectMapper.convertValue(ticketES, TicketVO.class);
    }

    @Override
    public List<TicketVO> getAll(Pageable pageable) {
        return mapperUtil.mapList(ticketESRepository.findAll(pageable), TicketVO.class);
    }
}
