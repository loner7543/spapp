package com.alma.ticket;

import com.alma.ticket.model.Ticket;
import com.alma.ticket.model.Trip;
import com.alma.ticket.service.TicketService;
import com.alma.ticket.vo.TicketVO;
import com.alma.ticket.vo.TripVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<TripVO> search(@RequestParam(value = "searchString") String search) {
        List<Trip> trips = ticketService.searchTrips(search);
        List<TripVO> tripVOList = new ArrayList<>();
        for (Trip trip:trips){
            TripVO vo = new TripVO(trip.getId(),trip.getFrom(),trip.getTo(),trip.getTripNumber());
            tripVOList.add(vo);
        }
        return tripVOList;
    }

    /*
    * Возвращает все незабронированные билеты
    * */
    @RequestMapping(value = "/getFreeTickets", method = RequestMethod.GET)
    public  @ResponseBody List<TicketVO> getFreeTickets(){
        List<Ticket> free = ticketService.getFreeTickets();
        List<TicketVO> ticketVOList = new ArrayList<>();
        for (Ticket ticket:free){
            TicketVO vo = new TicketVO(ticket.getId(),ticket.getNumber(),ticket.getPrice());
            ticketVOList.add(vo);
        }
        return ticketVOList;
    }

    @RequestMapping(value = "/createReservation", method = RequestMethod.POST)
    public void createReservation(@RequestParam(value = "ticketId") Long ticketId,
                                  @RequestParam(value = "userId") Long userId) {
        ticketService.createReservation(ticketId, userId);
    }

    @RequestMapping(value = "/cancelReservation", method = RequestMethod.DELETE)
    public void cancelReservation(@RequestParam(value = "ticketId") Long ticketId) {
        ticketService.cancelReservation(ticketId);
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public @ResponseBody List<TicketVO> loadTickets(@RequestParam(value = "userId") Long userId) {
        List<Ticket> tickets = ticketService.getAllTicketsForUser(userId);
        List<TicketVO> ticketVOList = new ArrayList<>();
        for (Ticket ticket:tickets){
            TicketVO vo = new TicketVO(ticket.getId(),ticket.getNumber(),ticket.getPrice());
            ticketVOList.add(vo);
        }
        return ticketVOList;
    }
}
