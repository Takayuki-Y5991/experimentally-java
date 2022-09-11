package com.example.javautilslibrary.infrastructure.repository;

import com.example.javautilslibrary.common.config.RedisConfig;
import com.example.javautilslibrary.infrastructure.repository.entity.RedisEntity;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RSetCache;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository implements InMemoryRepository<RedisEntity> {

    @Autowired
    private RedisConfig client;


    /**
     * {@inheritDoc}
     */
    @Override
    public void createBucket(RedisEntity entity) {
        RSetCache<String> bucket = this.client.getClient().getSetCache(entity.getAuthKey(), StringCodec.INSTANCE);
        bucket.add(entity.getValue(), 1, TimeUnit.DAYS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBucketValue(RedisEntity entity) {
        RSetCache<String> bucket = this.client.getClient().getSetCache(entity.getAuthKey(), StringCodec.INSTANCE);
        var result = bucket.readAll().stream().filter(e -> StringUtils.equals(e, entity.getValue())).findAny();
        return Objects.nonNull(bucket.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean compareCacheValue(RedisEntity entity) {
        RSetCache<String> bucket = this.client.getClient().getSetCache(entity.getAuthKey(), StringCodec.INSTANCE);
        var target = bucket.readAll().stream().filter(e -> StringUtils.equals(e, entity.getValue())).findAny();
        return target.isPresent();
    }
}
