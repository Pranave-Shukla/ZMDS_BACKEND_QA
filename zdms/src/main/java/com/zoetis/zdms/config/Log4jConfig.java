package com.zoetis.zdms.config;

import com.zoetis.zdms.filter.Log4jRestInvocationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4jConfig {

    private static final Integer LOG4J_REST_INVOCATION_FILTER_ORDER = 1;
    private static final String REST_INVOCATION_URL_PATTERN = "/api/*";

    @Bean
    public FilterRegistrationBean<Log4jRestInvocationFilter> log4jRestInvocationFilterRegistrationBean() {
        final FilterRegistrationBean<Log4jRestInvocationFilter> registrationBean = new FilterRegistrationBean<>();
        final Log4jRestInvocationFilter log4JRestInvocationFilter = new Log4jRestInvocationFilter();
        registrationBean.setFilter(log4JRestInvocationFilter);
        registrationBean.addUrlPatterns(REST_INVOCATION_URL_PATTERN);
        registrationBean.setOrder(LOG4J_REST_INVOCATION_FILTER_ORDER);
        return registrationBean;
    }
}
