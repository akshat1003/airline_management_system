package com.loconav.airline_management.model.response;

import com.loconav.airline_management.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalTime departureTime;
    private LocalTime expectedArrivalTime;
    private Integer numberOfSeats;
    private Integer numberOfBookedSeats;
    private String message;
}
