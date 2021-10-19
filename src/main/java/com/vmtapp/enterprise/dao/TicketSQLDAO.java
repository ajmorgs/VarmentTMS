package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TicketDAO")
public class TicketSQLDAO implements ITicketDao {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        Ticket createdTicket = ticketRepository.save(ticket);
        return createdTicket;
    }
}
