package com.bookShop.bookShop.service.validation.userValidation;

import com.bookShop.bookShop.dto.UserDto;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserUsernameValidation implements UserValidationRule {
    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userDto.getUsername() == null) {
            throw new ValidationException("Username must not be empty");
        } else if (userDto.getUsername().length() <= 3 || userDto.getUsername().length() >= 20) {
            throw new ValidationException("Username length must be longer than 3 symbols and shorter than 20 symbols!");
        }

    }
}
