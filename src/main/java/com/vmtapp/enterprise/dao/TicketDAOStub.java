package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class TicketDAOStub implements ITicketDao {

    List<Ticket> allTickets = new ArrayList<Ticket>();
    ITicketDao ticketDAO;

    /**
     * Takes a ticket as a parameter to be saved
     * @param ticket a ticket object to be saved
     * @return return the saved ticket
     */
    @Override
    public Ticket save(Ticket ticket) {
        allTickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> fetchAll() {
        return ticketDAO.fetchAll();
    }


}
