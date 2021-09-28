package com.vmtapp.enterprise.dto;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public @Data class Ticket {
    public String firstname;
    public  String lastname;
    public  String email;
    public int id;
    public  String status;
    public  String assignee;

    public Ticket(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;

        if(emailValidation(email))
        {
            this.email = email;
        }
        else
        {
          //  throw new Exception("Not a real Email Address!");
        }
    }

    private boolean emailValidation(String email)
    {
        String emailRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(emailRegEx);

        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
}
