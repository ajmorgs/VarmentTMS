package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TicketServiceStub implements ITicketService {

    @Override
    public ArrayList<Ticket> fetchTicketsByAssignee(String assignee) {
        ArrayList<Ticket> ticketsToReturn = new ArrayList<Ticket>();

        Ticket ticket = new Ticket();
        ticket.setFirstname("Larry");
        ticket.setLastname("Fine");
        ticket.setEmail("larry@test.com");
        ticketsToReturn.add(ticket);
        ticket.setFirstname("Moe");
        ticket.setLastname("Howard");
        ticket.setEmail("moe@test.com");
        ticketsToReturn.add(ticket);
        ticket.setFirstname("Shemp");
        ticket.setLastname("Howard");
        ticket.setEmail("shemp@test.com");
        ticketsToReturn.add(ticket);

        return ticketsToReturn;
    }

    public static boolean emailValidation(String email)
    {
        String emailRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(emailRegEx);

        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
}