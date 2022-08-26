package com.hcu.ticketservice.enums;

import lombok.Getter;

@Getter
public enum PriorityType {
    LOW("Acil"),
    HIGH("Yüksek"),
    URGENT("Düşük");

    private final String label;

    PriorityType(String label) {
        this.label = label;
    }
}
