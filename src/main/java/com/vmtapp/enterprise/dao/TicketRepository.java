package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {


}
