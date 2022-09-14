package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.AuthenticatedUserResponseDto;
import com.zoetis.zdms.api.dto.UserDto;
import com.zoetis.zdms.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapUserToDto(User user);

    AuthenticatedUserResponseDto mapUserToAuthenticatedUserResponseDto(User user);
}
