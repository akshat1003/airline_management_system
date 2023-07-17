package com.loconav.airline_management.service;

import com.loconav.airline_management.entity.Ticket;
import com.loconav.airline_management.model.request.TicketRequest;
import com.loconav.airline_management.model.response.TicketCreateResponse;
import com.loconav.airline_management.model.response.TicketResponse;

import java.util.List;

public interface ITicketService {
    TicketCreateResponse bookTicket(TicketRequest ticketRequest);

    List<Ticket> getAllTickets();

    Integer vacantSeats(String flightNumber);
}
