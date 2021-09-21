package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
import org.junit.jupiter.api.Test;
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

        try {
            ticket = new Ticket("John", "Smith", "mingusbingus");
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    private void thenAskUserToCheckEmail() {
    }

}