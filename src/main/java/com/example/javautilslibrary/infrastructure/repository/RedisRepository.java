package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.infrastructure.entity.RedisEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository implements InMemoryRepository<RedisEntity> {

    @Autowired
    private RedisTemplate<String, String> client;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createBucket(RedisEntity entity) {
        this.client.opsForValue().set(entity.getKey(), entity.getValue());
        this.client.expire(entity.getKey(), 1, TimeUnit.HOURS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBucketValue(RedisEntity entity) {
        var result = this.client.opsForValue().get(entity.getKey());
        return Objects.nonNull(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean compareCacheValue(RedisEntity entity) {
        var result = this.client.opsForValue().get(entity.getKey());
        return StringUtils.equals(result, result);
    }
}
