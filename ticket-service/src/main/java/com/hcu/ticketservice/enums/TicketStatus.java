package com.hcu.ticketservice.enums;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Üzerinde Çalışılıyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapandı");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
