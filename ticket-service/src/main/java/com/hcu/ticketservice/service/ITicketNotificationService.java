package com.hcu.ticketservice.service;

import com.hcu.ticketservice.vo.TicketVO;

public interface ITicketNotificationService {
    void sendToQueue(TicketVO ticket);
}
