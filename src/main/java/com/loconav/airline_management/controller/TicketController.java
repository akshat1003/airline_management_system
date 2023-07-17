package com.loconav.airline_management.controller;

import com.loconav.airline_management.entity.Ticket;
import com.loconav.airline_management.model.request.TicketRequest;
import com.loconav.airline_management.model.response.TicketCreateResponse;
import com.loconav.airline_management.model.response.TicketResponse;
import com.loconav.airline_management.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/airline/ticket")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/vacant_seats")
    public Integer vacantSeats(@RequestParam(value = "flight_number") final String flightNumber) {
        return ticketService.vacantSeats(flightNumber);
    }

    @PostMapping(value = "/bookTicket")
    public TicketCreateResponse bookTicket(@RequestBody final TicketRequest ticketRequest) {
        return ticketService.bookTicket(ticketRequest);
    }


}
