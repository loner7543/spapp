package com.alma.ticket;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/search")
    public String index() {
      List<Trip> trips =   ticketService.searchTrips(null);
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/createReservation")
    public void createReservation() {
        ticketService.createReservation(null,null);
    }

    @RequestMapping(value = "/cancelReservation")
    public void cancelReservation() {
        ticketService.cancelReservation(null);
    }

    @RequestMapping(value = "/load")
    public void loadTickets(){
      List<Ticket> tickets =  ticketService.getAllTicketsForUser(null);
    }
}
