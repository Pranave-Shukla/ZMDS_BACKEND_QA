package com.zoetis.zdms.service;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.model.User;
import com.zoetis.zdms.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.saml2.provider.service.authentication.DefaultSaml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class UserServiceImplTest extends UnitTest {

    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_FIRST_NAME_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/givenname";
    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_LAST_NAME_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/surname";
    private static final String AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_EMAIL_ADDRESS_ATTRIBUTE = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress";

    @Mock
    private Map<String, List<Object>> principalAttributes;

    @Mock
    private SecurityContextImpl securityContext;

    @Mock
    private Saml2Authentication authentication;

    @Mock
    private DefaultSaml2AuthenticatedPrincipal principal;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void shouldGetUser() {
        //given
        String firstName = "firstName";
        String lastName = "lastName";
        String emailAddress = "emailAddress";

        //when
        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {
            when(principalAttributes.get(AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_FIRST_NAME_ATTRIBUTE)).thenReturn(Collections.singletonList(firstName));
            when(principalAttributes.get(AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_LAST_NAME_ATTRIBUTE)).thenReturn(Collections.singletonList(lastName));
            when(principalAttributes.get(AAD_DEFAULT_SAML2_AUTHENTICATION_PRINCIPAL_USER_EMAIL_ADDRESS_ATTRIBUTE)).thenReturn(Collections.singletonList(emailAddress));

            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);
            when(securityContext.getAuthentication()).thenReturn(authentication);
            when(authentication.getPrincipal()).thenReturn(principal);
            when(principal.getAttributes()).thenReturn(principalAttributes);

            User user = userService.getUser();

            //then
            assertEquals(firstName, user.getFirstName());
            assertEquals(lastName, user.getLastName());
            assertEquals(emailAddress, user.getEmailAddress());
        }

    }
}
