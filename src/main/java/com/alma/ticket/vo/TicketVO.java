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

    public TicketVO(Long id, int number, int price) {
        this.id = id;
        this.number = number;
        this.price = price;
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
}
