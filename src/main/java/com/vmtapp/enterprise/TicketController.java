package com.vmtapp.enterprise;

import com.vmtapp.enterprise.dto.*;
import com.vmtapp.enterprise.dto.Error;
import com.vmtapp.enterprise.service.IPhotoService;
import com.vmtapp.enterprise.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TicketController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ITicketService ticketService;

    @Autowired
    IPhotoService photoService;
/*
Handle request to root of application
 */
    @RequestMapping("/")
    public String index(Model model){
        Ticket ticket = new Ticket();

       model.addAttribute(ticket);
        return "start";
    }

    @RequestMapping("/saveTicket")
    public ModelAndView saveTicket(Ticket ticket, @RequestParam("imageFile")MultipartFile imageFile){

        ModelAndView modelAndView = new ModelAndView();
        try{
            ticketService.save(ticket);
        }catch(Exception e){

            log.error(e.toString());
            modelAndView.setViewName("error");
            return modelAndView;
        }

        Photo photo = new Photo();

        if(!imageFile.isEmpty()){
        try{

            photo.setFileName(imageFile.getOriginalFilename());
            photo.setTicket(ticket);
            ticketService.saveImage(imageFile, photo);
        }catch (IOException e){

            log.error(e.toString());

            modelAndView = createErrorModelAndView("There was a problem saving the ticket",
                    "Please confirm that the details were correct and try again. If error persists, contact an admin");
            return modelAndView;

        }
        }
        modelAndView.setViewName("start");
        return modelAndView;
    }

    @RequestMapping(value = "/ticketsByDescription/{searchString}")
    public ModelAndView fetchTicketsByDescription(Model model, @PathVariable String searchString){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Ticket> tickets = ticketService.fetchTicketsByDescription(searchString);
            model.addAttribute("tickets", tickets);
            modelAndView.setViewName("ticketList");
            return modelAndView;
        } catch (IOException e){
            log.error(e.toString());
            modelAndView = createErrorModelAndView("There was aa problem fetching the tickets",
                    "Please confirm that the details were correct and try again. If error persists, contact an admin");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/ticketList")
    public ModelAndView fetchAllTickets(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Ticket> tickets = ticketService.fetchAll();
            modelAndView.addObject("tickets", tickets);

            modelAndView.setViewName("ticketList");
            return modelAndView;

        } catch (Exception e){
            log.error(e.toString());
            modelAndView = createErrorModelAndView("There was aa problem fetching the tickets",

                    "Please confirm that the details were correct and try again. If error persists, contact an admin");
            return modelAndView;
        }
    }

    @RequestMapping("/ticket/{assignee}")
    public ModelAndView fetchTicketsByAssignee(@PathVariable("assignee") String assignee) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Ticket> tickets = ticketService.fetchTicketsByAssignee(assignee);
            modelAndView.addObject("tickets", tickets);

            modelAndView.setViewName("ticketList");
            return modelAndView;

        } catch (Exception e){
            log.error(e.toString());
            modelAndView = createErrorModelAndView("There was aa problem fetching the tickets",

                    "Please confirm that the details were correct and try again. If error persists, contact an admin");
            return modelAndView;
        }

    }

    @GetMapping("/ticket/{id}")
    public ModelAndView fetchTicketById(@PathVariable("id") int id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();


        try{
            // This checks if the ticket exists, and if not, throws an exception
            Optional<Ticket> optionalTicket = Optional.ofNullable(ticketService.fetchTicketById(id).orElseThrow(
                    () -> new Exception("not found")
            ));

            // obviously this will only happen if ticket exists, so it's safe to convert optionalTicket to a Ticket object now
            Ticket ticket = new Ticket();
            ticket = optionalTicket.get();
            modelAndView.addObject("ticket", ticket);

            List<Photo> photos = photoService.fetchPhotoByTicketId(id);
            Photo photo = new Photo();
            if(!photos.isEmpty()){
                photo = photos.get(0);
            }

            modelAndView.addObject("photo", photo);
            modelAndView.setViewName("ticketDetails");

            return modelAndView;
        }catch (Exception e){
            e.printStackTrace();
            modelAndView = createErrorModelAndView("There was an error retrieving the ticket",
                    "Please confirm that the details were correct and try again. If error persists, contact an admin");
            return modelAndView;
        }

    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity deleteTicket(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/ticket", consumes="application/json", produces="application/json")
    public Ticket createTicket(@RequestBody Ticket ticket){

       Ticket newTicket = null;

        try {
            newTicket= ticketService.save(ticket);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return newTicket;
    }

    /**
     * Receives error details and prepares a ModelAndView object for it.
     * @param errorTitle
     * @param errorDetails
     * @return modelAndView - a populated ModelAndView object
     */
    private ModelAndView createErrorModelAndView (String errorTitle, String errorDetails){

        ModelAndView modelAndView = new ModelAndView();

        Error error = new Error();
        error.setTitle(errorTitle);
        error.setDetails(errorDetails);
        modelAndView.setViewName("error");
        modelAndView.addObject("error", error);

        return modelAndView;
    }



}
