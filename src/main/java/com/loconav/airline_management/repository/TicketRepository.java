package com.loconav.airline_management.repository;


import com.loconav.airline_management.entity.Ticket;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
