package com.loconav.airline_management.model.request;

import com.loconav.airline_management.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@Data
public class FlightRequest {

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalTime departureTime;
    private LocalTime expectedArrivalTime;
    private Integer numberOfSeats;
    private Integer numberOfBookedSeats;
    private FlightType flightType;

}
