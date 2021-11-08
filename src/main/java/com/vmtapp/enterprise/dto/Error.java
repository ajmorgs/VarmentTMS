package com.vmtapp.enterprise.dto;

import lombok.Data;

import java.util.Date;

public @Data
class Error {
    private String title;
    private String details;
    private Date time;
}
