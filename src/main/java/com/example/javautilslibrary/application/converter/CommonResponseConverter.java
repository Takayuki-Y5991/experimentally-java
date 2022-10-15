package com.example.javautilslibrary.application.converter;

import org.openapi.example.model.CreatedResponse;
import org.openapi.example.model.DeletedResponse;
import org.openapi.example.model.NoContentResponse;
import org.springframework.http.HttpStatus;

/**
 * REVIEW: if openapi generator will can handle @lombok.builder, must change builder
 * Common Response, 201, 204 or else, Converter
 */
public class CommonResponseConverter {

    /**
     * Deleted Response Converter
     *
     * @param target target
     * @return response
     */
    public static DeletedResponse buildDeleted(String target) {
        var response = new DeletedResponse();
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setMessage(target.concat(" Deleted."));
        return response;
    }

    /**
     * Created Response Converter
     *
     * @param target target
     * @return response
     */
    public static CreatedResponse buildCreated(String target) {
        var response = new CreatedResponse();
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage(target.concat(" Created."));
        return response;
    }

    /**
     * No Content Response Converter
     *
     * @param target target
     * @return response
     */
    public static NoContentResponse buildNoContent(String target) {
        var response = new NoContentResponse();
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setMessage(target.concat(" No Content."));
        return response;
    }

    /**
     * No Content Response Converter
     *
     * @param target target
     * @return response
     */
    public static NoContentResponse buildUpdated(String target) {
        var response = new NoContentResponse();
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setMessage(target.concat(" Updated."));
        return response;
    }
}
