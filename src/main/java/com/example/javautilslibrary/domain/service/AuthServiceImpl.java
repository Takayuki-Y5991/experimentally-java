package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.common.utils.JwtUtils;
import com.example.javautilslibrary.domain.object.entity.Token;
import com.example.javautilslibrary.infrastructure.repository.RedisRepository;
import com.example.javautilslibrary.infrastructure.repository.entity.RedisEntity;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Token getToken(String value) {
        var expiration = LocalDate.now().plusDays(1);
        redisRepository.createBucket(RedisEntity.buildValue(value));
        var token = jwtUtils.generateToken(value, Date.from(expiration.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return Token.build(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean confirmTokenKey(String value) {
        return redisRepository.getBucketValue(RedisEntity.buildValue(value));
    }
}
