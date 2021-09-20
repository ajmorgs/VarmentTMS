package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Ticket;

import java.util.List;

public interface ITicketService {

    /**
     * Checks user role by his/her email
     * @param email email of the user
     * @return status code : 0- user not found; 1- client; 2- technician
     */
    int checkUserRole(String email);

    /**
     * Retrieves all tickets that belong to the user with given email
     * @param email email
     * @return List<Ticket> list of tickets that belong to user
     */
    List<Ticket> fetchByEmail(String email);
}
