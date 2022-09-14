package com.zoetis.zdms.filter;

import com.zoetis.zdms.util.MultiReadHttpServletRequest;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Log4jRestInvocationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("REST request with method [{}] and endpoint [{}] has been invoked.", request.getMethod(), request.getRequestURI());
        MultiReadHttpServletRequest requestWrapper = new MultiReadHttpServletRequest(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        String requestBody = IOUtils.toString(requestWrapper.getInputStream(), UTF_8);
        log.debug("REST request body [{}].", requestBody);
        StopWatch watch = new StopWatch(getClass().getSimpleName());
        try {
            watch.start();
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            watch.stop();
            log.info("REST request completed with response status [{}] within: [{}] ms.", responseWrapper.getStatus(), watch.getTotalTimeMillis());
            log.debug("REST response body [{}]", IOUtils.toString(responseWrapper.getContentInputStream(), UTF_8));
            responseWrapper.copyBodyToResponse();
        }
    }
}
