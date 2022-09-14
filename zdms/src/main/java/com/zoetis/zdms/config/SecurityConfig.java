package com.zoetis.zdms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("!noSecurity")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String REGISTRATION_ID_PLACEHOLDER = "{registrationId}";

    @Value("${spring.security.saml2.login.processing-url}")
    private String saml2LoginProcessingUrl;

    @Value("${spring.security.saml2.handler.success.default-url}")
    private String saml2HandlerSuccessDefaultUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(
                        authorize ->
                                authorize
                                        .anyRequest()
                                        .authenticated()
                )
                .saml2Login(
                        saml2 -> {
                            saml2.loginProcessingUrl(String.format("%s%s", saml2LoginProcessingUrl, REGISTRATION_ID_PLACEHOLDER));
                            saml2.defaultSuccessUrl(saml2HandlerSuccessDefaultUrl, true);
                        }
                )
                .csrf()
                .disable();
    }
}
