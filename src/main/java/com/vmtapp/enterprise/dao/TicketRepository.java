package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

/*
TicketRepository extends CrudRepository interface for
methods to access persistent data store

@author Anthony Morgan
@version 1.0
* */

@Profile("!test")
public interface TicketRepository extends CrudRepository<Ticket, Integer> {


}
