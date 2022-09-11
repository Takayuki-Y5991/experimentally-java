package com.example.javautilslibrary.infrastructure.repository;

/**
 * Cache Server interface
 */
public interface InMemoryRepository<T> {

    /**
     * Create string data bucket
     *
     * @param source source
     */
    default void createBucket(T source) {
    }

    /**
     * Get value from key in bucket
     *
     * @param source source
     */
    default boolean getBucketValue(T source) {
        return false;
    }

    /**
     * Check value in key in bucket
     *
     * @param source source
     * @return boolean
     */
    default boolean compareCacheValue(T source) {
        return false;
    }

}
