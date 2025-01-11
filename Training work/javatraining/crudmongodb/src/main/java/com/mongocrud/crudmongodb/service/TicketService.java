package com.mongocrud.crudmongodb.service;

import com.mongocrud.crudmongodb.model.TicketModel;
import com.mongocrud.crudmongodb.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//to create the rest api methods
@Service
public class TicketService {
    //to get the crud method of mongodb spring
    @Autowired
    private TicketRepo repo;

    //add, fetch, delete, update tickets

    //add ticket using postman
    public TicketModel addTicket(TicketModel model)
    {
        return repo.save(model);
    }

    //get all tickets
    public List<TicketModel> getAllTickets(){
        return repo.findAll();
    }

    //to delete the ticket
    public String deleteTicket(int ticketId)
    {
        repo.deleteById(ticketId);
        return ticketId + " id is deleted successfully";
    }

    //to udpate the ticket
    public TicketModel updateTicket(int ticketId, TicketModel model)
    {
        model.setBookingId(ticketId);
        return repo.save(model);
    }

    //to get the ticket by ID
    public Optional<TicketModel> getTicketById(int ticketId)
    {
        return repo.findById(ticketId);
    }

}