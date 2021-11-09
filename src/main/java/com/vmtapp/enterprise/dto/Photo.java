package com.vmtapp.enterprise.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data
class Photo {

    @Id
    @GeneratedValue
    private int photoId;
    private String path;
    private String fileName;
    private String comments;


    @ManyToOne
    @JoinColumn(name="id")
    private Ticket ticket;
}
