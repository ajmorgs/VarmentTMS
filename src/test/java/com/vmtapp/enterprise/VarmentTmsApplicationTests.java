package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
<<<<<<< Updated upstream
=======
import com.vmtapp.enterprise.service.ITicketService;
import com.vmtapp.enterprise.service.TicketServiceStub;
>>>>>>> Stashed changes
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VarmentTmsApplicationTests {

    Ticket ticket;

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

<<<<<<< Updated upstream
        try {
            ticket = new Ticket("John", "Smith", "mingusbingus");
        }catch(Exception e)
        {
            System.out.println(e);
        }
=======

            ticket = new Ticket();
            ticket.setFirstname("John");
            ticket.setLastname("smith");
            ticket.setEmail("mingusbingus");
            assertEquals(false, TicketServiceStub.emailValidation(ticket.getEmail()));
>>>>>>> Stashed changes

    }

    private void thenAskUserToCheckEmail() {
    }

}