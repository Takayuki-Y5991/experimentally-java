package com.example.javautilslibrary.common.config;

import com.example.javautilslibrary.common.exception.ApiErrorResponse;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket swaggerPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(Set.of(MediaType.APPLICATION_JSON_VALUE))
                .produces(Set.of(MediaType.APPLICATION_JSON_VALUE))
                .globalRequestParameters(globalParameters())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/v1/.*"))
                .build()
                .apiInfo(apiInfo())
                .additionalModels(typeResolver.resolve(ApiErrorResponse.class))
                .globalResponses(HttpMethod.GET, getErrorResponse())
                .globalResponses(HttpMethod.POST, getErrorResponse());
    }

    private List<RequestParameter> globalParameters() {
        var authTokenHeader = new RequestParameterBuilder()
                .name("Authorization")
                .required(false)
                .in(ParameterType.HEADER)
                .description("Basic Auth Token, Adding Prefix [Bearer ]")
                .build();
        return Collections.singletonList(authTokenHeader);
    }

    private List<Response> getErrorResponse() {
        return new ArrayList<>() {
            {
                add(new ResponseBuilder()
                        .code("400")
                        .description("Bad Request")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r ->
                                r.model(m
                                        ->
                                        m.referenceModel(ref ->
                                                ref.key(k ->
                                                        k.qualifiedModelName(q ->
                                                                q.namespace(ApiErrorResponse.class.getPackageName())
                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
                add(new ResponseBuilder()
                        .code("401")
                        .description("Unauthorized")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r ->
                                r.model(m
                                        ->
                                        m.referenceModel(ref ->
                                                ref.key(k ->
                                                        k.qualifiedModelName(q ->
                                                                q.namespace(ApiErrorResponse.class.getPackageName())
                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
                add(new ResponseBuilder()
                        .code("403")
                        .description("Forbidden")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r ->
                                r.model(m
                                        ->
                                        m.referenceModel(ref ->
                                                ref.key(k ->
                                                        k.qualifiedModelName(q ->
                                                                q.namespace(ApiErrorResponse.class.getPackageName())
                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
                add(new ResponseBuilder()
                        .code("404")
                        .description("Not Found")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r ->
                                r.model(m
                                        ->
                                        m.referenceModel(ref ->
                                                ref.key(k ->
                                                        k.qualifiedModelName(q ->
                                                                q.namespace(ApiErrorResponse.class.getPackageName())
                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
                add(new ResponseBuilder()
                        .code("500")
                        .description("Internal Server Error")
                        .representation(MediaType.APPLICATION_JSON)
                        .apply(r ->
                                r.model(m
                                        ->
                                        m.referenceModel(ref ->
                                                ref.key(k ->
                                                        k.qualifiedModelName(q ->
                                                                q.namespace(ApiErrorResponse.class.getPackageName())
                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
            }
        };
    }

    @Bean
    public UiConfiguration swaggerUiConfiguration() {
        return UiConfigurationBuilder.builder()
                .displayRequestDuration(true)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Java Utilities Test API",
                "This Server is testing environment for library and try to common settings",
                "v1",
                "",
                DEFAULT_CONTACT,
                "",
                "",
                new ArrayList<>()
        );
    }
}
