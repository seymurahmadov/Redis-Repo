package com.example.redis.mapper;

import com.example.redis.dto.CustomerRequestDto;
import com.example.redis.dto.CustomerResponseDto;
import com.example.redis.entity.CustomerEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CustomerMapper {

    CustomerEntity mapRequestDtoToEntity(CustomerRequestDto customerRequestDto);

    List<CustomerResponseDto> mapEntityListToResponseList(Iterable<CustomerEntity> commentEntities);

    CustomerResponseDto mapEntityToResponseDto(CustomerEntity commentEntity);

    void update(@MappingTarget CustomerEntity commentEntity, CustomerRequestDto commentRequestDto);

}
