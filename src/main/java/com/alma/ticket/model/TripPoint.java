package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

/*
* Класс,содержащий информацию о маршруте(точке маршрута)
* */
@SequenceGenerator(name = "route_generator", sequenceName = "route_sequence")
@Entity
@Table(name = "trip_point")
public class TripPoint implements Serializable {

    @Id
    @GeneratedValue(generator = "route_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "pointName",nullable = false)
    private String pointName;

    /*
    * информация о рейсе к которому отнорится точка
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public TripPoint(){}

    public TripPoint(String pointName, Trip trip) {
        this.pointName = pointName;
        this.trip = trip;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
