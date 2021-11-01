package com.erdogan.can.utku.movie.userservice.service;

import com.erdogan.can.utku.movie.userservice.dto.converter.UserDtoConverter;
import com.erdogan.can.utku.movie.userservice.dto.request.AddRoleToUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.request.CreateUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.request.UpdateUserRequest;
import com.erdogan.can.utku.movie.userservice.dto.response.UserDto;
import com.erdogan.can.utku.movie.userservice.exception.RoleNotFoundException;
import com.erdogan.can.utku.movie.userservice.exception.UserNotFoundException;
import com.erdogan.can.utku.movie.userservice.model.Role;
import com.erdogan.can.utku.movie.userservice.model.User;
import com.erdogan.can.utku.movie.userservice.repository.RoleRepository;
import com.erdogan.can.utku.movie.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final UserDtoConverter converter;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, UserDtoConverter converter, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto getUserById(long id) {
        return converter.convert(findUserById(id));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return converter.convert(repository.getUserByUsername(username).orElseThrow(() -> new UserNotFoundException("Kullanıcı Bulunamadı")));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return converter.convert(repository.findAll());
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getSurname(),
                request.getAge(),
                request.getEmail(),
                request.getUsername(),
                passwordEncoder.encode(request.getPassword())
        );
        return converter.convert(repository.save(user));
    }

    @Override
    public UserDto updateUser(UpdateUserRequest request, long id) {
        User user = findUserById(id);
        User updatedUser = new User(
                user.getId(),
                request.getName(),
                request.getSurname(),
                request.getAge(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword()
        );
        return converter.convert(repository.save(updatedUser));
    }

    @Override
    public Role addRole(String roleName) {
        Role role = new Role(
                roleName
        );
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(AddRoleToUserRequest request) {
        User user = findUserByUsername(request.getUsername());
        Role role = roleRepository.getRoleByName(request.getRoleName()).orElseThrow(() -> new RoleNotFoundException("Rol Bulunamadı!"));
        user.getRoles().add(role);
    }

    @Override
    public void deleteUser(long id) {
        findUserById(id);
        repository.deleteById(id);
    }

    private User findUserById(final long id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Kullanıcı Bulunamadı"));
    }

    private User findUserByUsername(final String username){
        return repository.getUserByUsername(username).orElseThrow(() -> new UserNotFoundException("Kullanıcı Bulunamadı"));
    }
}
