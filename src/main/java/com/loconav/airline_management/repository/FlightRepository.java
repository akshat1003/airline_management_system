package com.loconav.airline_management.repository;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.enums.FlightType;
import com.loconav.airline_management.model.request.FlightFilterRequest;
import com.loconav.airline_management.model.response.FlightResponse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    @Query(value = "Select * from flights where :id is NULL or id=:id", nativeQuery = true)
    Flight getFlightById(@Param("id") final Integer id);

    @Query(value = "Select * from flights where (:id is NULL or id=:id) and (:flightNumber is NULL "
                   + "or flight_number=:flightNumber) and (:origin is NULL or origin=:origin) and"
                   + " (:destination is NULL "
                   + "or destination=:destination) ", nativeQuery = true)
    List<Flight> flightFilters(@Param("id") Integer id,
                               @Param("flightNumber")  String flightNumber,
                               @Param("origin")  String origin,
                               @Param("destination")  String destination);

    @Query(value = "Select f.number_of_booked_seats from flights as f where "
                   + "f.flight_number=:flightNumber",nativeQuery = true)
    Integer bookedSeats(String flightNumber);

    @Query(value = "Select f.number_of_seats from flights as f where "
                   + "f.flight_number=:flightNumber",nativeQuery = true)
    Integer totalSeats(String flightNumber);
}
