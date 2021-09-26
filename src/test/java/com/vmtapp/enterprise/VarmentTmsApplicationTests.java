package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dao.ITicketDao;
import com.vmtapp.enterprise.dto.Ticket;
import com.vmtapp.enterprise.service.ITicketService;
import com.vmtapp.enterprise.service.TicketServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VarmentTmsApplicationTests {

    @Autowired
    ITicketService ticketService;
    Ticket ticket;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    @MockBean
    private ITicketDao ticketDAO;

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

    @Test
    void saveTicketValidateAttributes(){
        givenUserIsClient();
        whenPostTicketWithAttributes();
        thenReturnSavedTicketWithAttributes();
    }

    private void givenUserIsClient() {
        Mockito.when(ticketDAO.save(ticket)).thenReturn(ticket);
        ticketService = new TicketServiceStub(ticketDAO);
    }

    private void whenPostTicketWithAttributes() {
        ticket.setFirstname("John");
        ticket.setLastname("Smith");
        ticket.setEmail("johnsmith@company.com");
    }

    private void thenReturnSavedTicketWithAttributes() {
        Ticket createdTicket = ticketService.save(ticket);
        assertEquals(createdTicket, ticket);
    }


}