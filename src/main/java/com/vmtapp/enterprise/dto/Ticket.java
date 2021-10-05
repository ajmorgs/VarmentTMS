package com.vmtapp.enterprise.dto;

import lombok.Data;

public @Data
class Ticket {
    public String firstname;
    public  String lastname;
    public  String email;
    public int id;
    public  String status;
    public  String assignee;
    public String description;
}
