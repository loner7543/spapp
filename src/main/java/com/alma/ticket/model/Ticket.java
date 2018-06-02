package com.alma.ticket.model;

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
    private Trip trip;

    /*
    * Пользователь, забронировавший билет
    * null - бмлет не забронирован
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
