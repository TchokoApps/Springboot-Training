package com.tchokouaha.spring.training.demospringboot.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Transactional(rollbackOn = RuntimeException.class, dontRollbackOn = Exception.class)
    public Ticket updateTicket(Long id, Ticket ticket) throws Exception {
        if(ticket.getName().length() < 2) {
            throw new RuntimeException("Name length must be greater than 2 characters");
        }

        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket savedTicket = ticketOptional.get();
            savedTicket.setName(ticket.getName());
            savedTicket.setEventDate(ticket.getEventDate());
            savedTicket.setPrice(ticket.getPrice());
            if(ticket.getAge() == null) {
                throw  new Exception("Age must not be NULL");
            }
            savedTicket.setAge(ticket.getAge());
            return savedTicket;
        } else {
            throw new RuntimeException("Ticket not found");
        }
    }
}
