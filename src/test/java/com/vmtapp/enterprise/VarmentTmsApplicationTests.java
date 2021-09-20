package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
import com.vmtapp.enterprise.service.ITicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class VarmentTmsApplicationTests {

    @Autowired
    private ITicketService ticketService;
    private List<Ticket> tickets;

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
        if(ticketService.checkUserRole("johnsmith@company.com") == 2){
            tickets = ticketService.fetchByEmail("johnsmith@company.com");
        }
        else
            thenReturnErrorJohnIsNotTechnician();

    }

    private void thenReturnErrorJohnIsNotTechnician() {
        fail("user johnsmith@company.com is not a technician");
    }

    @Test
    void fetchTicketsByEmail_returnsNull(){

        givenUserJaneIsATechnicianWithNoTickets();
        whenUserRequestsTicketsForJane();
        thenReturnNoTickets();
    }

    private void givenUserJaneIsATechnicianWithNoTickets() {
    }

    private void whenUserRequestsTicketsForJane() {
    }

    private void thenReturnNoTickets() {
    }

}
