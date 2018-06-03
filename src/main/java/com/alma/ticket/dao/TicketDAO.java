package com.alma.ticket.dao;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class TicketDAO extends BaseDAO {

    /*
    * Возвращает все билеты указанного пользователя
    * */
    public List<Ticket> getAllTicketsByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteria = builder.createQuery(Ticket.class);
        Root<Ticket> root = criteria.from(Ticket.class);
        criteria.select(root).where(builder.equal(root.get("id"), userId));// select * from ticket where user_ID = PARAM
        Query<Ticket> q=session.createQuery(criteria);
        List<Ticket> resList = q.getResultList();
        return resList;
    }

    /*
    * Отменяет бронь билета
    * */
   public void cancelReservation(Long ticketId){
       Session session = sessionFactory.getCurrentSession();
       Ticket ticket = session.get(Ticket.class,ticketId);
       ticket.setUser(null);
       session.update(ticket);
   }


   /*
   * Создает бронь на билет
   * */
   public void createReservation(User user,Long ticketId){
       Session session = sessionFactory.getCurrentSession();
       Ticket ticket = session.get(Ticket.class,ticketId);
       ticket.setUser(user);
       session.update(ticket);
   }


   /*
   * поиск рйсов
   * */
   public List searchTrip(String param){
       List trips  = Collections.emptyList();
       Query query;
       Session session = sessionFactory.getCurrentSession();
       if (tryParseInt(param)){
           int number = Integer.parseInt(param);
           query = session.createQuery("from Trip where number = :number").setParameter("number",number);
       }
       else{
            query=  session.createQuery("from Trip where from_point = :fp or to_point = :tp")
                   .setParameter("fp",param)
                   .setParameter("tp",param);
       }
       trips = query.getResultList();
       return trips;
   }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
