package com.loconav.airline_management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "flights")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight extends AbstractAirline {

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "expected_arrival_time")
    private String expectedArrivalTime;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "number_of_booked_seats")
    private Integer numberOfBookedSeats;
}
