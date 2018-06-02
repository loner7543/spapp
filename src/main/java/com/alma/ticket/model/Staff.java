package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "staff_generator", sequenceName = "staff_sequence")
@Entity
@Table(name = "staff")
public class Staff implements Serializable {

    @Id
    @GeneratedValue(generator = "staff_generator")
    @Column(name = "id",nullable = false)
    private Long id;
}
