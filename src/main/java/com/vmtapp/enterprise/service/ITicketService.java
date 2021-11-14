package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Photo;
import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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
  
      /**
    * fetch list of Tickets with given assignee
     * @param assignee
     * @return ArrayList<Ticket>
    * */
    ArrayList<Ticket> fetchTicketsByAssignee(String assignee);

    Ticket save(Ticket ticket);

    List<Ticket> fetchAll() throws IOException;

    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;

    Optional<Ticket> fetchTicketById(String s);
}
