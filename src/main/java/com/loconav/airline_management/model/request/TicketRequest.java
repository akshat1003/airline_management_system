package com.loconav.airline_management.model.request;
import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.enums.Gender;
import com.loconav.airline_management.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private String passengerName;
    private String passengerEmail;
    private String passengerMobileNumber;
    private String passengerAge;
    private PaymentStatus paymentStatus;
    private Gender gender;
    private Integer flightId;
}
