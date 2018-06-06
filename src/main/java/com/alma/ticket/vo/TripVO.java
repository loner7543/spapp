package com.alma.ticket.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TripVO implements Serializable {

    private Long id;

    private String from;

    private String to;

//    /*
//     * Рейс содержит в себе список точек следования
//     * */
//    private Set<TripPointVO> tripPoints = new HashSet<>();

    /*
     * Номер рейса
     */
    private int tripNumber;

    public TripVO(Long id, String from, String to, int tripNumber) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.tripNumber = tripNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }
}
