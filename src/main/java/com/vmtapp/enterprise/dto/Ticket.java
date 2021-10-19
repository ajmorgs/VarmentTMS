package com.vmtapp.enterprise.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data
class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String firstName;
    public  String lastName;
    public  String email;
    public  String status;
    public  String assignee;
    public String description;
}
