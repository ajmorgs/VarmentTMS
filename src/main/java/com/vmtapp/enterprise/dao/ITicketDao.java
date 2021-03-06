package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketDao {
    Ticket save(Ticket ticket);

    List<Ticket> fetchAll();

    Optional<Ticket> fetchTicketById(int id);

    List<Ticket> fetchTicketsByAssignee(String assignee);

    List<Ticket> fetchTicketsByDescription(String searchString);

}
