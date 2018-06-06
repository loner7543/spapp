package com.alma.ticket.service;

import com.alma.ticket.dao.TicketDAO;
import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Реализация сервиса
* */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public List<Trip> searchTrips(String searchString) {
       List<Trip> trips =  ticketDAO.searchTrip(searchString);
        return trips;
    }

    @Override
    public void createReservation(Long ticketId, Long user) {
        ticketDAO.createReservation(user,ticketId);
    }

    @Override
    public void cancelReservation(Long ticketId) {
         ticketDAO.cancelReservation(ticketId);
    }

    @Override
    public List<Ticket> getAllTicketsForUser(Long userId) {
        return ticketDAO.getAllTicketsByUser(userId);
    }

    @Override
    public List<Ticket> getFreeTickets() {
        return ticketDAO.getFreeTickets();
    }
}
