package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dao.ITicketDao;
import com.vmtapp.enterprise.dto.Ticket;
import com.vmtapp.enterprise.service.ITicketService;
import com.vmtapp.enterprise.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Optional;


@SpringBootTest
class VarmentTmsApplicationTests {

    @Autowired
    private ITicketService ticketService;
    private int userRole;
    private Ticket ticket = new Ticket();
    List<Ticket> tickets = new ArrayList<>();

    @MockBean
    private ITicketDao ticketDAO;

    @Test
    void contextLoads() {
    }
  
    @Test   // Test case 2.2
    void fetchTicketsByEmail_returnsErrorMessage(){
        givenUserJohnIsAClient();
        whenUserRequestsTicketsForJohn();
        thenReturnErrorJohnIsNotTechnician();

    }

    private void givenUserJohnIsAClient() {
    }

    private void whenUserRequestsTicketsForJohn() {

        // check if user is a technician
        userRole = ticketService.checkUserRole("johnsmith@company.com");


        // tickets are actually fetched only if the user is confirmed as a technician. That won't happen here
    }

    private void thenReturnErrorJohnIsNotTechnician() {
        assertEquals(1, userRole);  // role 1 = client
        System.out.println("user johnsmith@company.com is not a technician");
    }

    @Test   //Test case 2.3
    void fetchTicketsByEmail_returnsNull() throws Exception {

        givenUserJaneIsATechnicianWithNoTickets();
        whenUserRequestsTicketsForJane();
        thenReturnNoTickets();
    }

    private void givenUserJaneIsATechnicianWithNoTickets() {
    }

    private void whenUserRequestsTicketsForJane() throws Exception {


        // check if user is a technician
        int userRole = ticketService.checkUserRole("janesmith@company.com");
        assertEquals(2, userRole);  // role 2 = technician

        tickets = ticketService.fetchByEmail("janesmith@company.com");



    }

    private void thenReturnNoTickets() {
        assertNull(tickets);    // jane has no tickets assigned
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
            ticket.setFirstName("John");
            ticket.setLastName("smith");
            ticket.setEmail("mingusbingus");
    }

    private void thenAskUserToCheckEmail() {
    }


    @Test
    void fetchTicketsForJaneSmith() throws Exception {
        givenTicketDataIsAvailable();
        whenSearchTicketsForJaneSmith();
        thenReturnListOfTicketForJaneSmith();
    }

    private void thenReturnListOfTicketForJaneSmith() {
        int ticketListSize = tickets.size();
        assertEquals(3,ticketListSize);
    }

    private void whenSearchTicketsForJaneSmith() throws Exception {
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
        ticketService = new TicketService(ticketDAO);
    }

    private void whenPostTicketWithAttributes(){
        ticket.setFirstName("John");
        ticket.setLastName("Smith");
        ticket.setEmail("johnsmith@company.com");
    }

    private void thenReturnSavedTicketWithAttributes() {
        Ticket createdTicket = ticketService.save(ticket);
        assertEquals(ticket, createdTicket);
    }


 @Test
    void getTicketById10() throws Exception {
     givenTicketDataIsAvailable();
        whenIdIs10();
        thenReturnTicket();
        
 }

    private void whenIdIs10() {
        ticket.setId(10);
    }

    private void thenReturnTicket() throws Exception {
        Optional<Ticket> ticketToReturn = ticketService.fetchTicketById("10");
        assertEquals(ticket,ticketToReturn);
    }

    @Test void getAllTicketsWhereDescriptionIncludesCannotAccessEmail() throws Exception{
        givenTicketDataIsAvailable();
        whenDescriptionIsCannotAccessEmail();
        thenReturnTickets();
    }

    private void whenDescriptionIsCannotAccessEmail() {
        assertEquals(ticket.description,"Cannot Access Email");
    }



    private void thenReturnTickets() {

    }
}
