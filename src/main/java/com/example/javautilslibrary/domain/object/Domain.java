package com.example.javautilslibrary.domain.object;

import org.modelmapper.ModelMapper;

/**
 * Domain Marker
 *
 * @param <T> domain object
 */
public abstract class Domain<T> {

    protected static ModelMapper mapper = new ModelMapper();
}
