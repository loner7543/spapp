package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    /*
    * Логин
    * */
    @Column(name = "name",nullable = false)
    private String userName;

    /*
    * Пароль
    * */
    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,targetEntity = Ticket.class)
    private Set<Ticket> tickets;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, Set<Ticket> tickets, UserRole userRole) {
        this.userName = userName;
        this.password = password;
        this.tickets = tickets;
        this.userRole = userRole;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
