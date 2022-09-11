package com.example.javautilslibrary.infrastructure.repository.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * RedisEntity
 */
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class RedisEntity {

    /**
     * Secret-Key is token decryption key used
     */
    private final String authKey = "Secret-Key";
    private String value;
    private List<String> values;
    private Map<String, String> map;

    public static RedisEntity buildDefault() {
        return RedisEntity.builder().build();
    }

    public static RedisEntity buildValue(String value) {
        return RedisEntity.builder()
                .value(value)
                .build();
    }

    public static RedisEntity buildArray(List<String> values) {
        return RedisEntity.builder()
                .values(values)
                .build();
    }

    public RedisEntity buildMap(Map<String, String> map) {
        return RedisEntity.builder()
                .map(map)
                .build();
    }
}
