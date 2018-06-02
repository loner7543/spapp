package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "trip_generator", sequenceName = "trip_sequence")
@Entity
@Table(name = "trip")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(generator = "trip_generator")
    @Column(name = "id",nullable = false)
    private Long id;
}
