package com.loconav.airline_management.model.response;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.enums.Gender;
import com.loconav.airline_management.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private String passengerName;
    private String passengerEmail;
    private String passengerMobileNumber;
    private String passengerAge;
    private String ticketNumber;
    private PaymentStatus paymentStatus;
    private Gender gender;
    private Flight flight;

}
