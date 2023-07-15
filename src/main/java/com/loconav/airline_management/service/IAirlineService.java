package com.loconav.airline_management.service;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;

import java.util.List;

public interface IAirlineService {

    FlightResponse addNewFlight(FlightRequest flightRequest);

    List<FlightResponse> getAllFlights();
}
