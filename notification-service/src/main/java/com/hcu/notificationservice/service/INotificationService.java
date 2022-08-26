package com.hcu.notificationservice.service;

import com.hcu.dto.messaging.TicketNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface INotificationService {
    @RabbitListener(queues = {"msqueue"})
    void onNotification(TicketNotification ticketNotification);
}
