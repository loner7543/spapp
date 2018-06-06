package com.alma.ticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/*
* Класс описывающий билет
* */
@SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_sequence")
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(generator = "ticket_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    public Ticket(){}

    /*
    * Уникальный номер билета
    * */
    @Column(name = "ticket_number",unique = true)
    private int number;

    /*
    * Стоимость билета
    * */
    @Column(name = "price",nullable = false)
    private int price;

    /*
    * Рейс, к которому относится билет
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    @JsonBackReference
    private Trip trip;

    /*
    * Пользователь, забронировавший билет
    * null - бмлет не забронирован
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket(int number, int price, Trip trip, User user) {
        this.number = number;
        this.price = price;
        this.trip = trip;
        this.user = user;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
