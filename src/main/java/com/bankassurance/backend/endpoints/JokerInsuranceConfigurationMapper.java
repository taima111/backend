package com.bankassurance.backend.endpoints;

import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JokerInsuranceConfigurationMapper {
    JokerInsuranceConfiguration toEntity(JokerInsuranceConfiguration dto);
}