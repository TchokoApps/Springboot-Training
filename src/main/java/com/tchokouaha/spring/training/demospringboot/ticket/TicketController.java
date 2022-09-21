package com.tchokouaha.spring.training.demospringboot.ticket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.of(Optional.of(tickets));
    }

    @GetMapping("/{id}") // /api/ticket/3
    public ResponseEntity<Ticket> getOneTicket(@PathVariable long id) {
        Ticket ticket = new Ticket();
        return ResponseEntity.of(Optional.of(ticket));
    }

    @PostMapping("tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody @Valid Ticket ticket) {
        Ticket savedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.of(Optional.of(savedTicket));
    }

    @PutMapping("/tickets/{ticketId}")
    public ResponseEntity<Ticket> editTicket(@PathVariable(value = "ticketId") Long ticketId,
                                             @RequestBody Ticket ticket) throws Exception {
        Ticket ticketSaved = ticketService.updateTicket(ticketId, ticket);
        return ResponseEntity.of(Optional.of(ticketSaved));
    }

}
