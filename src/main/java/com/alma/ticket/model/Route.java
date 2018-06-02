package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "route_generator", sequenceName = "route_sequence")
@Entity
@Table(name = "route")
public class Route implements Serializable {

    @Id
    @GeneratedValue(generator = "route_generator")
    @Column(name = "id",nullable = false)
    private Long id;
}
