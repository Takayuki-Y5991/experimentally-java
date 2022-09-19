package com.example.javautilslibrary.common.config;

import com.example.javautilslibrary.common.config.anotation.Authorize;
import com.example.javautilslibrary.common.config.anotation.NonAuthorize;
import com.example.javautilslibrary.common.exception.AccessDeniedException;
import com.example.javautilslibrary.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;


@Component
public class AuthorizationHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Pre-execution processing of the rest controller <br>
     * Authorization Process via annotation
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check cast
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // Get process method information
        Method method = ((HandlerMethod) handler).getMethod();
        // Non Authorization processing when method given @NonAuthorize
        if (Objects.nonNull(AnnotationUtils.findAnnotation(method, NonAuthorize.class))) {
            return true;
        }
        // Get process controller information
        Class<?> controller = method.getDeclaringClass();
        if (Objects.nonNull(AnnotationUtils.findAnnotation(method, Authorize.class))) {
            // Check authorization
            if (!jwtUtils.authorize.test(request)) {
                throw new AccessDeniedException("Access denied");
            }
        }
        return true;
    }
}
