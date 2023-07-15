package com.loconav.airline_management.controller;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.model.request.FlightRequest;
import com.loconav.airline_management.model.response.FlightResponse;
import com.loconav.airline_management.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {
    @Autowired
    private IAirlineService airlineService;

    @GetMapping
    public List<FlightResponse> getAllFlights()
    {
        return airlineService.getAllFlights();
    }

    @PostMapping(value="/addFlight")
    public FlightResponse addNewFlight(@RequestBody final FlightRequest flightRequest)
    {
        return airlineService.addNewFlight(flightRequest);
    }
}
