package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAOStub implements ITicketDao {

    List<Ticket> allTickets = new ArrayList<Ticket>();

    @Override
    public Ticket save(Ticket ticket) {
        allTickets.add(ticket);
        return ticket;
    }
    public List fetchAll(){
        return allTickets;
    }
}
