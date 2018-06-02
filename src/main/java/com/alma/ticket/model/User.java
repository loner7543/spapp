package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

/*
* Описывает пользователя в системе
* */
@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
@Entity
@Table(name = "app_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "user_generator")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
