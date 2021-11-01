package com.erdogan.can.utku.movie.userservice.dto.converter;

import com.erdogan.can.utku.movie.userservice.dto.response.UserDto;
import com.erdogan.can.utku.movie.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAge(),
                from.getEmail(),
                from.getUsername()
        );
    }
    public List<UserDto> convert(List<User> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }

}
