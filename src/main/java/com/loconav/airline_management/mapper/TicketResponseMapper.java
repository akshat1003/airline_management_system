package com.loconav.airline_management.mapper;

import com.loconav.airline_management.entity.Ticket;
import com.loconav.airline_management.model.response.TicketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TicketResponseMapper {

    TicketResponseMapper INSTANCE = Mappers.getMapper(TicketResponseMapper.class);
    TicketResponse mapTicketResponse(final Ticket ticket);


}
