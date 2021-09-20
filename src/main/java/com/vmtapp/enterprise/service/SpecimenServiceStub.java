package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpecimenServiceStub implements ITicketService{

    // need some methods here - fetch and return error message, fetch and return no tickets assigned.

    @Override
    public List<Ticket> fetchByEmail(String email) {
        List<Ticket> userTickets = new ArrayList<>();

        Ticket ticketOne = new Ticket();
        return userTickets;
    }
}
