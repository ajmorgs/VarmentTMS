package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VarmentTmsApplicationTests {

    @Autowired
    private ticket;

    @Test
    void contextLoads() {
    }

    @Test
    void testRegExOfEmail() {
        
        givenUserHasSubmittedATicket();
        thenAskUserToCheckEmail();
        whenUserSubmitsInvalidEmailField();

        
    }

    private void givenUserHasSubmittedATicket() {

    }

    private void whenUserSubmitsInvalidEmailField() {

        ticket = new Ticket();
    }

    private void thenAskUserToCheckEmail() {
    }

}