package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
import com.vmtapp.enterprise.service.ITicketService;
import com.vmtapp.enterprise.service.TicketServiceStub;
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


            ticket = new Ticket();
            ticket.setFirstname("John");
            ticket.setLastname("smith");
            ticket.setEmail("mingusbingus");
            assertEquals(false, TicketServiceStub.emailValidation(ticket.getEmail()));

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