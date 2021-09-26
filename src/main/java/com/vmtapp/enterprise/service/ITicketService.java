package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;

import java.util.ArrayList;
import java.util.List;

public interface ITicketService {
    /**
    * fetch list of Tickets with given assignee
     * @param assignee
     * @return ArrayList<Ticket>
    * */
    ArrayList<Ticket> fetchTicketsByAssignee(String assignee);

    Ticket save(Ticket ticket);
}
