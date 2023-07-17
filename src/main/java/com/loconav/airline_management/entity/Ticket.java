package com.loconav.airline_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.loconav.airline_management.enums.Gender;
import com.loconav.airline_management.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Builder
@Audited
@Table(name="tickets")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends AbstractAirline {

    @Column(name="passenger_name")
    private String passengerName;

    @Column(name="passenger_email")
    private String passengerEmail;

    @Column(name="passenger_mobile_number")
    private String passengerMobileNumber;

    @Column(name="passenger_age")
    private String passengerAge;

    @Column(name="ticket_number")
    private String ticketNumber;

    @Column(name="payment_status")
    private PaymentStatus paymentStatus;

    @Column(name="gender")
    private Gender gender;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;




}
