package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketServiceStub implements ITicketService {

    @Override
    public ArrayList<Ticket> fetchTicketsByAssignee(String assignee) {
        ArrayList<Ticket> ticketsToReturn = new ArrayList<Ticket>();

        Ticket ticket = new Ticket("Larry","Fine","larry@test.com");
        ticketsToReturn.add(ticket);
        ticket = new Ticket("Moe","Howard","moe@test.com");
        ticketsToReturn.add(ticket);
        ticket = new Ticket("Shemp","Howard","shemp@test.com");
        ticketsToReturn.add(ticket);

        return ticketsToReturn;
    }
}
