package com.tchokouaha.spring.training.demospringboot.ticket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findAll();

}
