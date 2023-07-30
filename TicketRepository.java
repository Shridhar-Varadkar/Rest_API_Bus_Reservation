package com.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crud.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{

}
