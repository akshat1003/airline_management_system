package com.loconav.airline_management.service.impl;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.entity.Ticket;
import com.loconav.airline_management.mapper.TicketResponseMapper;
import com.loconav.airline_management.model.request.TicketRequest;
import com.loconav.airline_management.model.response.TicketCreateResponse;
import com.loconav.airline_management.model.response.TicketResponse;
import com.loconav.airline_management.repository.FlightRepository;
import com.loconav.airline_management.repository.TicketRepository;
import com.loconav.airline_management.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TicketResponseMapper ticketResponseMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketCreateResponse bookTicket(TicketRequest ticketRequest) {
        Flight flight = flightRepository.getFlightById(ticketRequest.getFlightId());
        if (flightRepository.totalSeats(flight.getFlightNumber()) - flightRepository.bookedSeats(
                flight.getFlightNumber()) == 0) {
            return TicketCreateResponse.builder()
                    .response("Unable to book Ticket. All seats booked.").build();
        }

        Ticket ticket = Ticket.builder().gender(ticketRequest.getGender()).flight(flight)
                .passengerAge(ticketRequest.getPassengerAge())
                .passengerEmail(ticketRequest.getPassengerEmail())
                .passengerName(ticketRequest.getPassengerName())
                .passengerMobileNumber(ticketRequest.getPassengerMobileNumber())
                .paymentStatus(ticketRequest.getPaymentStatus()).build();
        ticket = ticketRepository.save(ticket);
        return TicketCreateResponse.builder().response("Success").build();


    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Integer vacantSeats(String flightNumber) {
        Integer bookedSeats = flightRepository.bookedSeats(flightNumber);
        Integer totalSeats = flightRepository.totalSeats(flightNumber);
        return totalSeats - bookedSeats;
    }
}
