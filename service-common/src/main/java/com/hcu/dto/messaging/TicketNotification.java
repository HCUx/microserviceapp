package com.hcu.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TicketNotification implements Serializable {
    private String ticketId;
    private String accountId;
    private String ticketDescription;
}
