package com.example.javautilslibrary.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoggingHandlerInterceptor loggingHandlerInterceptor;

    @Autowired
    private AuthorizationHandlerInterceptor authorizationHandlerInterceptor;

    /**
     * Interceptor Settings
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingHandlerInterceptor)
                .addPathPatterns("/api/v1/*");
        registry.addInterceptor(authorizationHandlerInterceptor)
                .addPathPatterns("/api/v1/*");
    }


}
