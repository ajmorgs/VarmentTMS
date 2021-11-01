package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TicketDAO")
@Profile({"dev", "default"})
public class TicketSQLDAO implements ITicketDao {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        Ticket createdTicket = ticketRepository.save(ticket);
        return createdTicket;
    }

    @Override
    public List<Ticket> fetchAll() {
        return null;
    }
}