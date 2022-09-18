package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.application.response.TokenResponse;
import com.example.javautilslibrary.common.mapper.TokenMapper;
import com.example.javautilslibrary.common.utils.JwtUtils;
import com.example.javautilslibrary.infrastructure.entity.RedisEntity;
import com.example.javautilslibrary.infrastructure.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private TokenMapper mapper;


    //TODO: Domain return

    /**
     * {@inheritDoc}
     */
    @Override
    public TokenResponse getToken(String value) {
        var expiration = LocalDate.now().plusDays(1);
        redisRepository.createBucket(RedisEntity.buildValue(value));
        var token = jwtUtils.generateToken(value, Date.from(expiration.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean confirmTokenKey(String value) {
        return redisRepository.getBucketValue(RedisEntity.buildValue(value));
    }
}
