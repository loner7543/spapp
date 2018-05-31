package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {

    @Id
    @GeneratedValue
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
