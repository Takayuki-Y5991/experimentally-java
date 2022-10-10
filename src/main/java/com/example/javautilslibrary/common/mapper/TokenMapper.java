package com.example.javautilslibrary.common.mapper;


import com.example.javautilslibrary.common.config.ConfigMapper;
import com.example.javautilslibrary.domain.object.entity.Token;
import org.mapstruct.Mapper;
import org.openapi.example.model.TokenResponse;

@Mapper(config = ConfigMapper.class)
public interface TokenMapper {
    TokenResponse toTokenResponse(Token domain);

    Token toDomain(String token);
}
