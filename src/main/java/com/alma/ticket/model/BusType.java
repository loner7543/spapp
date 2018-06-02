package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "type_generator", sequenceName = "type_sequence")
@Entity
@Table(name = "bus_type")
public class BusType implements Serializable {

    @Id
    @GeneratedValue(generator = "type_generator")
    @Column(name = "id",nullable = false)
    private Long id;
}
