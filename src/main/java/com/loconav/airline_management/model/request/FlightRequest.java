package com.loconav.airline_management.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class FlightRequest {

    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String expectedArrivalTime;
    private Integer numberOfSeats;
    private Integer numberOfBookedSeats;

}
