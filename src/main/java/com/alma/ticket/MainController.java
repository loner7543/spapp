package com.alma.ticket;

import com.alma.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private TicketService busService;

    @RequestMapping("/asd")
    public String index() {
        busService.getAll();
        return "Greetings from Spring Boot!";
    }
}
