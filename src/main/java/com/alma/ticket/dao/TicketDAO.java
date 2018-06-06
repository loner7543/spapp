package com.alma.ticket.dao;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class TicketDAO extends BaseDAO {

    private static final Logger logger = LoggerFactory.getLogger(TicketDAO.class);
    /*
    * Возвращает все билеты указанного пользователя
    * */
    public List<Ticket> getAllTicketsByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteria = builder.createQuery(Ticket.class);
        Root<Ticket> root = criteria.from(Ticket.class);
        criteria.select(root).where(builder.equal(root.get("user"), userId));// select * from ticket where user_ID = PARAM
        Query<Ticket> q=session.createQuery(criteria);
        List<Ticket> resList = q.getResultList();
        if (resList.size()!=0){
            logger.info("Билеты получены");
        }
        else {
            logger.info("Список билетов пуст");
        }
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
       logger.info("Бронь отменена");
   }


   /*
   * Создает бронь на билет
   * */
   public void createReservation(Long userId,Long ticketId){
       Session session = sessionFactory.getCurrentSession();
       Ticket ticket = session.get(Ticket.class,ticketId);
       User user = session.get(User.class,userId);
       ticket.setUser(user);
       session.update(ticket);
       logger.info("Бронь создана");
   }


   /*
   * поиск рйсов
   * */
   public List<Trip> searchTrip(String param){
       List<Trip> trips;
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
       if (trips.size()==0){
           logger.info("Рейсы не найдены");
       }
       else logger.info("Рейсы найдены");
       trips.forEach(trip->{
           trip.getTripPoints().size();
           trip.getTickets().size();
       });
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

    public List<Ticket> getFreeTickets(){
       return null;
    }


}
