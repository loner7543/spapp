package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
* Класс, описывающий рейс
* */
@SequenceGenerator(name = "trip_generator", sequenceName = "trip_sequence")
@Entity
@Table(name = "trip")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(generator = "trip_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    /*
    * Пункт отправления
    * */
    @Column(name = "from_point",nullable = false)
    private String from;

    /*
    * Пункт назначения
    * */
    @Column(name = "to_point",nullable = false)
    private String to;

    /*
    * Рейс содержит в себе список точек следования
    * */
    @OneToMany(mappedBy = "trip",cascade =  CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = TripPoint.class)
    private Set<TripPoint> tripPoints = new HashSet<>();

    /*
    * Набор билетов с уникальными номерами для каждого рейса
    * */
    @OneToMany(mappedBy = "trip",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Ticket.class)
    private Set<Ticket> tickets = new HashSet<>();

    /*
    * Номер рейса
    */
    @Column(name = "number",nullable = false)
    private int tripNumber;

    public Trip(){}

    public Trip(String from, String to, Set<TripPoint> tripPoints, Set<Ticket> tickets, int tripNumber) {
        this.from = from;
        this.to = to;
        this.tripPoints = tripPoints;
        this.tickets = tickets;
        this.tripNumber = tripNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Set<TripPoint> getTripPoints() {
        return tripPoints;
    }

    public void setTripPoints(Set<TripPoint> tripPoints) {
        this.tripPoints = tripPoints;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
