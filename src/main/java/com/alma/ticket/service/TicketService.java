package com.alma.ticket.service;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.model.User;

import java.util.List;
import java.util.function.LongFunction;

/*
* Интерфейс сервиса для работы с билетами
* */
public interface TicketService {

    /*
    * Поиск билета на рейс
    * */
    List<Trip> searchTrips(String searchString);

    /*
    * Создает бронь на билет
    * */
    void createReservation(Long ticketId, User user);

    /**
    * отменяет бронь на билет
     * */
    void cancelReservation(Long ticketId);

    /*
    * Возвращает все билеты пользователя
    * */
    List<Ticket>  getAllTicketsForUser(Long userId);
}
