package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dao.IPhotoDAO;
import com.vmtapp.enterprise.dao.ITicketDao;
import com.vmtapp.enterprise.dao.TicketSQLDAO;
import com.vmtapp.enterprise.dto.Photo;
import com.vmtapp.enterprise.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TicketService implements ITicketService{

    @Autowired
    TicketSQLDAO ticketSQLDAO;

    @Autowired
    private IPhotoDAO photoDAO;

    @Override
    public int checkUserRole(String email) {
        int statusCode = 0;

        if(email.equals("johnsmith@company.com"))
            statusCode = 1; // client
        if(email.equals("janesmith@company.com"))
            statusCode = 2; // technician

        return statusCode;
    }

    @Override
    public List<Ticket> fetchByEmail(String email) {
        List<Ticket> userTickets = new ArrayList<>();   // technician's tickets

        if (email.equals("janesmith@company.com"))  //jane smith has no tickets
            return null;


        return userTickets;
    }

    @Autowired
    private ITicketDao ticketDao;

    public TicketService(){}

    public TicketService(ITicketDao ticketDao){

        this.ticketDao = ticketDao;
    }

    @Override
    public ArrayList<Ticket> fetchTicketsByAssignee(String assignee) {
        ArrayList<Ticket> ticketsToReturn = new ArrayList<Ticket>();

        Ticket ticket = new Ticket();
        ticket.setFirstName("Larry");
        ticket.setLastName("Fine");
        ticket.setEmail("larry@test.com");
        ticketsToReturn.add(ticket);
        ticket.setFirstName("Moe");
        ticket.setLastName("Howard");
        ticket.setEmail("moe@test.com");
        ticketsToReturn.add(ticket);
        ticket.setFirstName("Shemp");
        ticket.setLastName("Howard");
        ticket.setEmail("shemp@test.com");
        ticketsToReturn.add(ticket);

        return ticketsToReturn;
        
    }

    public static boolean emailValidation(String email)
    {
        String emailRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(emailRegEx);

        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    @Override
    public Ticket save(Ticket ticket) {

        return ticketDao.save(ticket);
    }

    @Override
    public List<Ticket> fetchAll(){
        return ticketSQLDAO.fetchAll();
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageFile, photo);
    }

    @Override
    public Optional<Ticket> fetchTicketById(String s) {
        return Optional.empty();
    }

    @Override
    public List<Ticket> fetchTicketsByDescription(String searchString){
        return ticketSQLDAO.fetchTicketsByDescription(searchString);
    }

}
