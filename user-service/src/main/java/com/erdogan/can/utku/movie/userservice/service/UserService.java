package com.erdogan.can.utku.movie.userservice.service;

import com.erdogan.can.utku.movie.userservice.dto.request.AddRoleToUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.request.CreateUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.request.UpdateUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.response.UserDto;
import com.erdogan.can.utku.movie.userservice.model.Role;

import java.util.List;

public interface UserService {

    UserDto getUserById(final long id);
    UserDto getUserByUsername(final String username);
    List<UserDto> getAllUsers();
    UserDto createUser(final CreateUserRequest request);
    UserDto updateUser(final UpdateUserRequest request, final long id);
    Role addRole(final String roleName);
    void addRoleToUser(final AddRoleToUserRequest request);
    void deleteUser(final long id);
}
