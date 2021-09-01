package com.vmtapp.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

/*
Handle request to root of application
 */
    @RequestMapping("/")
    public String index(){
        return "start";
    }
}
