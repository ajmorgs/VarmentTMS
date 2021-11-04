package com.vmtapp.enterprise.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.gson.annotations.SerializedName;

@Entity
public @Data
class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int TicketId;
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
    @SerializedName("description")
    public String description;

    public String toString(){
        return "Description: " + description + "\n" + "Assigned to: " + assignee + "\n" + " Status: " + status;
    }
}
