package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    @Autowired
    private KafkaTemplate<String, Integer> kafkaTemplate;

    @Override
    public Ticket save(Ticket ticket) {
        Ticket createdTicket = ticketRepository.save(ticket);

        kafkaTemplate.send("ticketIn","id", createdTicket.getId());
        Ticket blank = new Ticket();
        blank.setFirstName("");
        blank.setLastName("");
        blank.setDescription("");
        blank.setEmail("");

        return blank;
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
        return ticketRepository.findById(id);

    }

    @Override
    public List<Ticket> fetchTicketsByAssignee(String assignee) {
        List<Ticket> allTickets = new ArrayList<>();
        Iterable<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets) {
            if(ticket.assignee.toLowerCase().contains(assignee.toLowerCase())){
                allTickets.add(ticket);
            }
        }
        return allTickets;

    }
  
    @Override
    public List<Ticket> fetchTicketsByDescription(String searchString) {
        List<Ticket> allTickets = new ArrayList<>();
        Iterable<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets) {
            if(ticket.description.toLowerCase().contains(searchString.toLowerCase())){
                allTickets.add(ticket);
            }
        }
        return allTickets;
    }

}

