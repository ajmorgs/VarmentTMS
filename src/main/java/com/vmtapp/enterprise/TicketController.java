package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TicketController {

/*
Handle request to root of application
 */
    @RequestMapping("/")
    public String index(){
        return "start";
    }

    @RequestMapping("/ticket")
    public ResponseEntity fetchAllTickets(){
        return new ResponseEntity(HttpStatus.OK);
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
    public ResponseEntity createTicket(@RequestBody Ticket ticket){
        return new ResponseEntity(HttpStatus.OK);
    }



}
