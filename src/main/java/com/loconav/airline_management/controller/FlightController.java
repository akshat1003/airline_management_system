package com.loconav.airline_management.controller;

import com.loconav.airline_management.enums.FlightType;
import com.loconav.airline_management.model.request.FlightFilterRequest;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;
import com.loconav.airline_management.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airline/flight")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    @GetMapping
    public List<FlightResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/get_flight")
    public FlightResponse getFlightById(
            @RequestParam(value = "id", required = false) final Integer id,
            @RequestParam(value = "flight_number", required = false) final String flightNumber) {
        return flightService.getFlightById(id, flightNumber);
    }

    @GetMapping("/flight_filters")
    public List<FlightResponse> flightFilters(
            @RequestParam(value = "id", required = false) final Integer id,
            @RequestParam(value = "flight_number", required = false) final String flightNumber,
            @RequestParam(value = "origin ", required = false) final String origin,
            @RequestParam(value = "destination", required = false) final String destination,
            @RequestParam(value = "flight_type", required = false) final FlightType flightType) {
        FlightFilterRequest flightFilterRequest =
                FlightFilterRequest.builder().flightNumber(flightNumber).id(id).origin(origin)
                        .destination(destination).build();
        return flightService.flightFilters(flightFilterRequest);
    }

    @PostMapping(value = "/add_flight")
    public FlightResponse addNewFlight(@RequestBody final FlightRequest flightRequest) {
        return flightService.addNewFlight(flightRequest);
    }
}
