package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "bus_generator", sequenceName = "bus_sequence")
@Entity
@Table(name = "bus")
public class Bus implements Serializable {

    @Id
    @GeneratedValue(generator = "bus_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name")
    private String busName;

    public Bus(){}

    public Bus(String busName) {
        this.busName = busName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }
}
