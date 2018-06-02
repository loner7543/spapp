package com.alma.ticket.dao;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class TicketDAO extends BaseDAO {

    /*
    * Возвращает все билеты указанного пользователя
    * */
    public List<Ticket> getAllTicketsByUser(User user) {
        return Collections.emptyList();
    }

    /*
    * Отменяет бронь билета
    * */
   public boolean cancelReservation(){return false;}


   /*
   * Создает бронь на билет
   * */
   public boolean createReservation(){return false;}


   /*
   * поиск рйсов
   * */
   public List<Trip> searchTrip(User user){return null;}


}
