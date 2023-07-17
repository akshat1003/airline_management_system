package com.loconav.airline_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.loconav.airline_management.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.List;


@Entity
@Audited
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
    private LocalTime departureTime;

    @Column(name = "expected_arrival_time")
    private LocalTime expectedArrivalTime;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "number_of_booked_seats")
    private Integer numberOfBookedSeats;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Ticket> tickets;

    @Column(name="flight_type")
    private FlightType flightType;
}
