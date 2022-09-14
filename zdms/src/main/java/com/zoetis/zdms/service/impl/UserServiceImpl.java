package com.zoetis.zdms.service.impl;

import com.zoetis.zdms.exception.MissingUserAttribute;
import com.zoetis.zdms.model.User;
import com.zoetis.zdms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.DefaultSaml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_FIRST_NAME_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/givenname";
    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_LAST_NAME_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/surname";
    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_EMAIL_ADDRESS_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress";

    @Override
    public User getUser() {
        log.info("[getUser] started processing]");
        Saml2Authentication authentication = (Saml2Authentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultSaml2AuthenticatedPrincipal principal = (DefaultSaml2AuthenticatedPrincipal) authentication.getPrincipal();
        Map<String, List<Object>> principalAttributes = principal.getAttributes();

        String firstName = getFirstAttributeValueForName(principalAttributes, AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_FIRST_NAME_ATTRIBUTE);
        String lastName = getFirstAttributeValueForName(principalAttributes, AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_LAST_NAME_ATTRIBUTE);
        String emailAddress = getFirstAttributeValueForName(principalAttributes, AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_EMAIL_ADDRESS_ATTRIBUTE);

        return User.of(firstName, lastName, emailAddress);
    }

    private String getFirstAttributeValueForName(Map<String, List<Object>> principalAttributes, String value) {
        return principalAttributes
                .get(value)
                .stream()
                .findFirst()
                .map(String::valueOf)
                .orElseThrow(() -> new MissingUserAttribute(String.format("Attribute not found: %s", value)));
    }

}
