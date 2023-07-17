package com.loconav.airline_management.model.request;

import com.loconav.airline_management.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightFilterRequest {
    private Integer id;
    private String flightNumber;
    private String origin;
    private FlightType flightType;
    private String destination;
}
