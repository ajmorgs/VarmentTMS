package com.vmtapp.enterprise.dto;

import lombok.Data;

public @Data
class Ticket {
    public  int    ticketId;
    public  String firstName;
    public  String lastName;
    public  String email;
    public  String status;
    public  String assignee;
    public  String description;
}
