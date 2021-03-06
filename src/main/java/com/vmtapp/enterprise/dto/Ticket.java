package com.vmtapp.enterprise.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity
public @Data
class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SerializedName("id")
    public int id;
    @SerializedName("firstName")
    public String firstName;
    @SerializedName("lastName")
    public String lastName;
    @SerializedName("email")
    public String email;
    @SerializedName("status")
    public String status;
    @SerializedName("assignee")
    public String assignee;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("creationDate")
    public Date creationDate;


    public String toString(){
        return "id: " + id + "description: " + description + "\n" + "Assigned to: " + assignee + " Status: " + status;
    }
}
