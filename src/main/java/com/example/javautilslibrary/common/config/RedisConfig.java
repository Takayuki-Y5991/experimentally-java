package com.example.javautilslibrary.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Redis (Redisson) Config
 */
@Component
public class RedisConfig {

    @Value("${redis.server.address}")
    private String address;

    private RedissonClient client;

    public RedissonClient getClient() {
        if (Objects.isNull(this.client)) {
            Config config = new Config();
            config.useSingleServer()
                    .setAddress(address);
            this.client = Redisson.create(config);
        }
        return this.client;
    }
}
