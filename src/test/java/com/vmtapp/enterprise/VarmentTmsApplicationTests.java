package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
import com.vmtapp.enterprise.service.ITicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VarmentTmsApplicationTests {

    @Autowired
    ITicketService ticketService;
    Ticket ticket;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    @Test
    void contextLoads() {
    }

    @Test
    void testRegExOfEmail(){
        
        givenUserHasSubmittedATicket();
        thenAskUserToCheckEmail();
        whenUserSubmitsInvalidEmailField();

    }

    private void givenUserHasSubmittedATicket() {

    }

    private void whenUserSubmitsInvalidEmailField(){

        try {
            ticket = new Ticket("John", "Smith", "mingusbingus");
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    private void thenAskUserToCheckEmail() {
    }

    @Test
    void fetchTicketsForJaneSmith(){
        givenTicketDataIsAvailable();
        whenSearchTicketsForJaneSmith();
        thenReturnListOfTicketForJaneSmith();
    }

    private void thenReturnListOfTicketForJaneSmith() {
        int ticketListSize = tickets.size();
        assertEquals(3,ticketListSize);
    }

    private void whenSearchTicketsForJaneSmith() {
       tickets = ticketService.fetchTicketsByAssignee("janesmith@company.com");

    }
    private void givenTicketDataIsAvailable() {

    }


}