package com.example.javautilslibrary.infrastructure.entity;

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

    private String key;
    private String value;
    private List<String> values;
    private Map<String, String> map;

    public static RedisEntity buildValue(String key, String value) {
        return RedisEntity.builder()
                .key(key)
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
