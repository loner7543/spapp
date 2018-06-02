package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

/*
* Класс, содержащий инфомацию о персонале
* */
@SequenceGenerator(name = "staff_generator", sequenceName = "staff_sequence")
@Entity
@Table(name = "staff")
public class Staff implements Serializable {

    @Id
    @GeneratedValue(generator = "staff_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "person_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;

    public Staff(){}

    public Staff(String name, StaffType staffType) {
        this.name = name;
        this.staffType = staffType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public Staff(String name) {
        this.name = name;
    }
}
