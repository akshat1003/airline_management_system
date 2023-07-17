package com.loconav.airline_management.service;

import com.loconav.airline_management.enums.FlightType;
import com.loconav.airline_management.model.request.FlightFilterRequest;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;

import java.util.List;

public interface IFlightService {

    FlightResponse addNewFlight(FlightRequest flightRequest);

    List<FlightResponse> getAllFlights();

    FlightResponse getFlightById(Integer id, String flightNumber);


    List<FlightResponse> flightFilters(FlightFilterRequest flightFilterRequest);
}
