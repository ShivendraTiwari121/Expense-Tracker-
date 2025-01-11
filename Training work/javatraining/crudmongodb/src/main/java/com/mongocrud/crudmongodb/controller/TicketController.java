package com.mongocrud.crudmongodb.controller;

import com.mongocrud.crudmongodb.model.TicketModel;
import com.mongocrud.crudmongodb.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping()
    public TicketModel addTickets(@RequestBody TicketModel ticketModel)
    {
        return service.addTicket(ticketModel);
    }

    @GetMapping()
    public List<TicketModel> getAllTickets(){
        return service.getAllTickets();
    }

    @DeleteMapping(value = "/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") @RequestBody int ticketId)
    {
        return service.deleteTicket(ticketId);
    }

    @PutMapping(value = "/{ticketId}")
    public TicketModel updateTicket(@PathVariable("ticketId") @RequestBody int ticketId,
                                    @RequestBody TicketModel model){
        return service.updateTicket(ticketId, model);
    }

    @GetMapping(value = "/{ticketId}")
    public Optional<TicketModel> getTicketById(@PathVariable("ticketId") @RequestBody int ticketId)
    {
        return service.getTicketById(ticketId);
    }
}