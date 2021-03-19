package com.bookShop.bookShop.mapper;

import com.bookShop.bookShop.domain.User;
import com.bookShop.bookShop.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
