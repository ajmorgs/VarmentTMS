package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;

import java.util.List;

public interface ITicketDAO {
    Ticket save(Ticket ticket);

    List<Ticket> fetchAll();
}
