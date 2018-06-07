package com.alma.ticket.vo;

import java.io.Serializable;

public class TicketVO implements Serializable {

    private Long id;

    /*
     * Уникальный номер билета
     * */
    private int number;

    /*
     * Стоимость билета
     * */
    private int price;

    private TripVO tripVO;

    public TicketVO(Long id, int number, int price, TripVO tripVO) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.tripVO = tripVO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TripVO getTripVO() {
        return tripVO;
    }

    public void setTripVO(TripVO tripVO) {
        this.tripVO = tripVO;
    }
}
