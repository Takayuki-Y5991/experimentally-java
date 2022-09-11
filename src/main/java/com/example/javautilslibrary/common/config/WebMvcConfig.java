package com.example.javautilslibrary.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    LoggingHandlerInterceptor loggingHandlerInterceptor() {
        return new LoggingHandlerInterceptor();
    }

    @Bean
    AuthorizationHandlerInterceptor authorizationHandlerInterceptor() {
        return new AuthorizationHandlerInterceptor();
    }

    /**
     * Interceptor Settings
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingHandlerInterceptor())
                .addPathPatterns("/api/v1/*");
        registry.addInterceptor(authorizationHandlerInterceptor())
                .addPathPatterns("/api/v1/*");
    }


}
