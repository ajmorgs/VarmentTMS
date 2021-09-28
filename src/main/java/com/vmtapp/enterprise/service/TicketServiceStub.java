package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketServiceStub implements ITicketService{

    @Override
    public int checkUserRole(String email) {
        int statusCode = 0;

        if(email.equals("johnsmith@company.com"))
            statusCode = 1; // client
        if(email.equals("janesmith@company.com"))
            statusCode = 2; // technician

        return statusCode;
    }

    @Override
    public List<Ticket> fetchByEmail(String email) {
        List<Ticket> userTickets = new ArrayList<>();   // technician's tickets

        if (email.equals("janesmith@company.com"))  //jane smith has no tickets
            return null;


        return userTickets;
    }



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
