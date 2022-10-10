package com.example.javautilslibrary.common.config;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Autowired
//    private TypeResolver typeResolver;
//
//    @Bean
//    public Docket swaggerPlugin() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .consumes(Set.of(MediaType.APPLICATION_JSON_VALUE))
//                .produces(Set.of(MediaType.APPLICATION_JSON_VALUE))
//                .globalRequestParameters(globalParameters())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.regex("/api/v1/.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .additionalModels(typeResolver.resolve(ApiErrorResponse.class))
//                .globalResponses(HttpMethod.GET, getErrorResponse())
//                .globalResponses(HttpMethod.POST, getErrorResponse());
//    }
//
//    private List<RequestParameter> globalParameters() {
//        var authTokenHeader = new RequestParameterBuilder()
//                .name("Authorization")
//                .required(false)
//                .in(ParameterType.HEADER)
//                .description("Basic Auth Token, Adding Prefix [Bearer ]")
//                .build();
//        return Collections.singletonList(authTokenHeader);
//    }
//
//    private List<Response> getErrorResponse() {
//        return new ArrayList<>() {
//            {
//                add(new ResponseBuilder()
//                        .code("400")
//                        .description("Bad Request")
//                        .representation(MediaType.APPLICATION_JSON)
//                        .apply(r ->
//                                r.model(m
//                                        ->
//                                        m.referenceModel(ref ->
//                                                ref.key(k ->
//                                                        k.qualifiedModelName(q ->
//                                                                q.namespace(ApiErrorResponse.class.getPackageName())
//                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
//                add(new ResponseBuilder()
//                        .code("401")
//                        .description("Unauthorized")
//                        .representation(MediaType.APPLICATION_JSON)
//                        .apply(r ->
//                                r.model(m
//                                        ->
//                                        m.referenceModel(ref ->
//                                                ref.key(k ->
//                                                        k.qualifiedModelName(q ->
//                                                                q.namespace(ApiErrorResponse.class.getPackageName())
//                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
//                add(new ResponseBuilder()
//                        .code("403")
//                        .description("Forbidden")
//                        .representation(MediaType.APPLICATION_JSON)
//                        .apply(r ->
//                                r.model(m
//                                        ->
//                                        m.referenceModel(ref ->
//                                                ref.key(k ->
//                                                        k.qualifiedModelName(q ->
//                                                                q.namespace(ApiErrorResponse.class.getPackageName())
//                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
//                add(new ResponseBuilder()
//                        .code("404")
//                        .description("Not Found")
//                        .representation(MediaType.APPLICATION_JSON)
//                        .apply(r ->
//                                r.model(m
//                                        ->
//                                        m.referenceModel(ref ->
//                                                ref.key(k ->
//                                                        k.qualifiedModelName(q ->
//                                                                q.namespace(ApiErrorResponse.class.getPackageName())
//                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
//                add(new ResponseBuilder()
//                        .code("500")
//                        .description("Internal Server Error")
//                        .representation(MediaType.APPLICATION_JSON)
//                        .apply(r ->
//                                r.model(m
//                                        ->
//                                        m.referenceModel(ref ->
//                                                ref.key(k ->
//                                                        k.qualifiedModelName(q ->
//                                                                q.namespace(ApiErrorResponse.class.getPackageName())
//                                                                        .name(ApiErrorResponse.class.getSimpleName())))))).build());
//            }
//        };
//    }
//
//    @Bean
//    public UiConfiguration swaggerUiConfiguration() {
//        return UiConfigurationBuilder.builder()
//                .displayRequestDuration(true)
//                .defaultModelRendering(ModelRendering.EXAMPLE)
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Java Utilities Test API",
//                "This Server is testing environment for library and try to common settings",
//                "v1",
//                "",
//                DEFAULT_CONTACT,
//                "",
//                "",
//                new ArrayList<>()
//        );
//    }
}
