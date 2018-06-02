package com.alma.ticket.service;

import com.alma.ticket.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO busDAO;

    @Override
    public void getAll() {
        busDAO.getAllTicketsByUser(null);// todo fix it
    }
}
