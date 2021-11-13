package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
TicketSQLDAO provides implementation of ITicketDao interface
methods

@Author Anthony Morgan
@version 1.0
* */

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
        List<Ticket> allTickets = new ArrayList<>();
        Iterable<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets) {
            allTickets.add(ticket);
        }
        return allTickets;
    }

    @Override
    public Optional<Ticket> fetchTicketById(int id) {
        Optional<Ticket> ticketToReturn = ticketRepository.findById(id);
        return ticketToReturn;

    }
}
