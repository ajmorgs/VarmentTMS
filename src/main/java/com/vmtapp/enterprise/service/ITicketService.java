package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;

import java.util.List;

public interface ITicketService {
    /**
     * Retrieves all tickets that belong to the user with given email
     * @param email email
     * @return List<Ticket> list of tickets that belong to user
     */
    List<Ticket> fetchByEmail(String email);
}
