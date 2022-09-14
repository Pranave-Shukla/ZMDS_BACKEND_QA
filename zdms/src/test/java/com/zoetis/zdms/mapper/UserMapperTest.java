package com.zoetis.zdms.mapper;

import com.zoetis.zdms.UnitTest;
import com.zoetis.zdms.api.dto.AuthenticatedUserResponseDto;
import com.zoetis.zdms.api.dto.UserDto;
import com.zoetis.zdms.model.User;
import com.zoetis.zdms.util.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest extends UnitTest {

    @Spy
    @InjectMocks
    private UserMapperImpl userMapper;

    @Test
    void shouldMapUserToUserDto() {
        //given
        User user = UserFactory.buildDefaultUser();

        //when
        AuthenticatedUserResponseDto mappingResult = userMapper.mapUserToAuthenticatedUserResponseDto(user);

        //then
        UserDto mappingResultElement = mappingResult.getUser();

        assertEquals(UserFactory.FIRST_NAME, mappingResultElement.getFirstName());
        assertEquals(UserFactory.LAST_NAME, mappingResultElement.getLastName());
        assertEquals(UserFactory.EMAIL_ADDRESS, mappingResultElement.getEmailAddress());
    }
}
