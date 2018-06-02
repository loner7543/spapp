package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_sequence")
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(generator = "ticket_generator")
    @Column(name = "id",nullable = false)
    private Long id;


}
