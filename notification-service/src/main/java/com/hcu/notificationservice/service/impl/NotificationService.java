package com.hcu.notificationservice.service.impl;

import com.hcu.dto.messaging.TicketNotification;
import com.hcu.notificationservice.service.INotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService implements INotificationService {
    @Override
    @RabbitListener(queues = {"msqueue"})
    public void onNotification(TicketNotification ticketNotification) {
        log.info("Notification Received: {}", ticketNotification);
    }
}
