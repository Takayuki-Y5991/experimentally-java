package com.example.javautilslibrary.application.converter;


import org.openapi.example.model.Tag;
import org.openapi.example.model.TagResponse;

import java.util.List;

public class TagResponseConverter {

    public static TagResponse buildBookResponse(List<Tag> source) {
        var response = new TagResponse();
        response.setCount(source.size());
        response.setTags(source);
        return response;
    }
}
