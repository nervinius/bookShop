package com.bookShop.bookShop.service.validation.userValidation;

import com.bookShop.bookShop.dto.UserDto;
import com.bookShop.bookShop.repository.userRepository.UserRepository;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUniqueUsernameValidation implements UserValidationRule {

    private UserRepository userRepository;

    @Autowired
    public UserUniqueUsernameValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ValidationException("User with this Username already exist");
        }
    }
}
