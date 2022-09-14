package com.zoetis.zdms.rest;

import com.zoetis.zdms.api.dto.AuthenticatedUserResponseDto;
import com.zoetis.zdms.api.rest.UserApi;
import com.zoetis.zdms.mapper.UserMapper;
import com.zoetis.zdms.model.User;
import com.zoetis.zdms.rest.factory.ResponseEntityFactory;
import com.zoetis.zdms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    private final UserMapper userMapper;

    @Override
    public ResponseEntity<AuthenticatedUserResponseDto> getAuthenticatedUser() {
        User user = userService.getUser();

        AuthenticatedUserResponseDto authenticatedUserResponseDto = userMapper.mapUserToAuthenticatedUserResponseDto(user);

        return ResponseEntityFactory.buildOk(authenticatedUserResponseDto);
    }
}
