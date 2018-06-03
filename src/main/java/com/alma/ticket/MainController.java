package com.alma.ticket;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {


    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private TicketService ticketService;

    @RequestMapping("/search")
    public String index() {
      List<Trip> trips =   ticketService.searchTrips("Волгоград");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/createReservation")
    public void createReservation() {
        ticketService.createReservation(1L,1L);
    }

    @RequestMapping(value = "/cancelReservation")
    public void cancelReservation() {
        ticketService.cancelReservation(1L);
    }

    @RequestMapping(value = "/load")
    public void loadTickets(){
      List<Ticket> tickets =  ticketService.getAllTicketsForUser(1L);
      int i = 1;
    }
}
