package com.loconav.airline_management.service.impl;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.enums.FlightType;
import com.loconav.airline_management.mapper.FlightResponseMapper;
import com.loconav.airline_management.model.request.FlightFilterRequest;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;
import com.loconav.airline_management.repository.FlightRepository;
import com.loconav.airline_management.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightResponseMapper flightResponseMapper;


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
                        .expectedArrivalTime(flight.getExpectedArrivalTime())
                        .message("Successfully Created Flight").build();
        return flightResponse;
    }

    @Override
    public List<FlightResponse> getAllFlights() {

        List<Flight> flight = flightRepository.findAll();
        return flightResponseMapper.mapGetFlightRequest(flight);
    }

    @Override
    public FlightResponse getFlightById(Integer id, String flightNumber) {
        return flightResponseMapper.mapFlightResponse(flightRepository.getFlightById(id));

    }

//    @Override
//    public List<FlightResponse> flightFilters(Integer id, String flightNumber, String origin,
//                                              String destination, FlightType flightType) {
//        return flightResponseMapper.mapGetFlightRequest(
//                flightRepository.flightFilters(id,flightNumber,origin,destination));
//    }

    @Override
    public List<FlightResponse> flightFilters(FlightFilterRequest flightFilterRequest) {
        System.out.println(flightFilterRequest);
        return flightResponseMapper.mapGetFlightRequest(
                flightRepository.flightFilters(flightFilterRequest.getId(),
                        flightFilterRequest.getFlightNumber(), flightFilterRequest.getOrigin(),
                        flightFilterRequest.getDestination()));
    }


}
