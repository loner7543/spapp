package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

/*
* Описывает автобус в системе
* */
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

    @Enumerated(EnumType.STRING)
    private BusType busType;

    public Bus(){}

    public Bus(String busName, BusType busType) {
        this.busName = busName;
        this.busType = busType;
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

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }
}
