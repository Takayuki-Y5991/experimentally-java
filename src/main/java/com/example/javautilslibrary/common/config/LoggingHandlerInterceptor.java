package com.example.javautilslibrary.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class LoggingHandlerInterceptor implements HandlerInterceptor {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Header - Italic target names
     */
    private final List<String> EXCLUDED_HEADERS = List.of("password", "Authorization", "Auth", "pass", "Basic", "pwd");

    /**
     * Italic
     */
    private final String ITALIC = "********************************";


    /**
     * Pre-execution processing of the rest controller
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("================================= Request Begin =================================");
        log.info("[method] : {}", request.getMethod());
        log.info("[uri] : {}", request.getRequestURI());
        log.info("[param] : {}", mapper.writeValueAsString(request.getParameterMap()));

        if (StringUtils.equals(request.getMethod(), HttpMethod.POST.toString())
                || StringUtils.equals(request.getMethod(), HttpMethod.PUT.toString())) {
            byte[] requestBody = StreamUtils.copyToByteArray(request.getInputStream());
            log.info("[requestBody]: {}", new String(requestBody, StandardCharsets.UTF_8));
        }
        this.getHeaders(request);
        log.info("================================= Request End ====================================");
        return true;
    }

    private void getHeaders(HttpServletRequest request) {
        Enumeration<?> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String current = (String) e.nextElement();
            String value = List.of(EXCLUDED_HEADERS).contains(current) ? ITALIC : (String) request.getHeader(current);
            log.info("[" + current + "] : " + value);
        }
    }

    /**
     * Post-execution processing of the controller
     *
     * @param request      current HTTP request
     * @param response     current HTTP response
     * @param handler      the handler (or {@link HandlerMethod}) that started asynchronous
     *                     execution, for type and/or instance examination
     * @param modelAndView the {@code ModelAndView} that the handler returned
     *                     (can also be {@code null})
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        String json = new String(responseWrapper.getContentAsByteArray(), responseWrapper.getCharacterEncoding());
        log.info("[postHandle][" + json + "]");
    }

    /**
     * After processing of the controller
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  the handler (or {@link HandlerMethod}) that started asynchronous
     *                 execution, for type and/or instance examination
     * @param ex       any exception thrown on handler execution, if any; this does not
     *                 include exceptions that have been handled through an exception resolver
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (Objects.nonNull(ex)) {
            log.info("================================= Complete Begin ===============================");
            ex.printStackTrace();
            log.info("[exception]: {}", ex.getMessage());
            log.info("================================= Complete End =================================");
        }
    }

}
