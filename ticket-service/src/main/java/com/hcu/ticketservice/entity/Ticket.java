package com.hcu.ticketservice.entity;

import com.hcu.ticketservice.enums.PriorityType;
import com.hcu.ticketservice.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ticket")
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntityModel {
    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "description", length = 600)
    @Getter
    @Setter
    private String description;

    @Column(name = "notes", length = 4000)
    @Getter
    @Setter
    private String notes;

    @Column(name = "assignee", length = 50)
    @Getter
    @Setter
    private String assignee;

    @Column(name = "ticket_date")
    @Getter
    @Setter
    private Date ticketDate;

    @Column(name = "priority_type")
    @Getter
    @Setter
    private PriorityType priorityType;

    @Column(name = "ticket_status")
    @Getter
    @Setter
    private TicketStatus ticketStatus;

}
