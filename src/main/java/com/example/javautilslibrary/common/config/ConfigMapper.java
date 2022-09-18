package com.example.javautilslibrary.common.config;


import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface ConfigMapper {
}