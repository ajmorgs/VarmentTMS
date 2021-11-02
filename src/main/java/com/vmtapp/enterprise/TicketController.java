package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.*;
import com.vmtapp.enterprise.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class TicketController {

    @Autowired
    ITicketService ticketService;
/*
Handle request to root of application
 */
    @RequestMapping("/")
    public String index(Model model){
        Ticket ticket = new Ticket();
        ticket.setEmail("larry@test.com");
        ticket.setAssignee("morganaj@uc.edu");
        ticket.setStatus("unassigned");
        ticket.setFirstName("Larry");
        ticket.setLastName("Fine");
        model.addAttribute(ticket);
        return "start";
    }

    @RequestMapping("/saveTicket")
    public String saveTicket(Ticket ticket){
        try{
            ticketService.save(ticket);
        }catch(Exception e){
            Logger log = Logger.getLogger("ticket");
            log.info(e.toString());
            return "error";
        }

        return "start";
    }

    @RequestMapping(value = "/ticketList")
    public String fetchAllTickets(Model model){
        try {
            List<Ticket> tickets = ticketService.fetchAll();
            model.addAttribute("tickets", tickets);
            return "ticketList";
        } catch (IOException e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/ticket/{assignee}")
    public ResponseEntity fetchTicketsByAssignee(@PathVariable("assignee") String assignee){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/ticket/{id}")
    public ResponseEntity fetchTicketById(@PathVariable("id") String id){

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity deleteTicket(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/ticket", consumes="application/json", produces="application/json")
    public Ticket createTicket(@RequestBody Ticket ticket){

       Ticket newTicket = null;

        try {
            newTicket= ticketService.save(ticket);
        } catch (Exception e) {

        }

        return newTicket;
    }



}
