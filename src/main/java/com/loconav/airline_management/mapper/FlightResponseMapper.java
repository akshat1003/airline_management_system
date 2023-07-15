package com.loconav.airline_management.mapper;

import com.loconav.airline_management.entity.Flight;
import com.loconav.airline_management.model.response.FlightResponse;
import com.loconav.airline_management.service.impl.AirlineService;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = {
        AirlineService.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FlightResponseMapper {

    FlightResponseMapper INSTANCE = Mappers.getMapper(FlightResponseMapper.class);

    List<FlightResponse> mapGetFlightRequest(final List<Flight> flight);
}
