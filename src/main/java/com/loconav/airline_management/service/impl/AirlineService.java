package com.loconav.airline_management.service.impl;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.mapper.FlightResponseMapper;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;
import com.loconav.airline_management.repository.FlightRepository;
import com.loconav.airline_management.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirlineService {

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public FlightResponse addNewFlight(FlightRequest flightRequest) {
        Flight flight = Flight.builder().flightNumber(flightRequest.getFlightNumber())
                .numberOfSeats(flightRequest.getNumberOfSeats())
                .numberOfBookedSeats(flightRequest.getNumberOfBookedSeats())
                .destination(flightRequest.getDestination())
                .departureTime(flightRequest.getDepartureTime())
                .expectedArrivalTime(flightRequest.getExpectedArrivalTime())
                .origin(flightRequest.getOrigin()).build();

        flight = flightRepository.save(flight);
        FlightResponse flightResponse =
                FlightResponse.builder().flightNumber(flight.getFlightNumber())
                        .numberOfSeats(flight.getNumberOfSeats())
                        .numberOfBookedSeats(flight.getNumberOfBookedSeats())
                        .departureTime(flight.getDepartureTime())
                        .destination(flight.getDestination()).origin(flight.getOrigin())
                        .expectedArrivalTime(flight.getExpectedArrivalTime()).message(
                                "Successfully Created Flight").build();
        return flightResponse;
    }

    @Override
    public List<FlightResponse> getAllFlights() {

        List<Flight> flight=flightRepository.findAll();
        return FlightResponseMapper.INSTANCE.mapGetFlightRequest(flight);
    }
}
