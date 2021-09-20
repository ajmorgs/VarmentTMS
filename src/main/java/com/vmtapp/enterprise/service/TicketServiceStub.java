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
}
