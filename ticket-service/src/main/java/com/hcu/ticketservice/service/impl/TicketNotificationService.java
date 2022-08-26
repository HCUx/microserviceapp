package com.hcu.ticketservice.service.impl;

import com.hcu.dto.messaging.TicketNotification;
import com.hcu.ticketservice.service.ITicketNotificationService;
import com.hcu.ticketservice.vo.TicketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketNotificationService implements ITicketNotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String QUEUE;

    @Override
    public void sendToQueue(TicketVO ticket) {
        TicketNotification ticketNotification = TicketNotification.builder()
                .ticketId(ticket.getId())
                .accountId(ticket.getAssignee())
                .ticketDescription(ticket.getDescription())
                .build();
        log.info("Notification Created: {}", ticketNotification);
        rabbitTemplate.convertAndSend(QUEUE, QUEUE, ticketNotification);
        log.info("Notification Sent.");
    }
}
