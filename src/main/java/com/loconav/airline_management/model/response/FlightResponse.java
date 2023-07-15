package com.loconav.airline_management.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String expectedArrivalTime;
    private Integer numberOfSeats;
    private Integer numberOfBookedSeats;
    private String message;
}
