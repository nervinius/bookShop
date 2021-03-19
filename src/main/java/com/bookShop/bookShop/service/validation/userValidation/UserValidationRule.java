package com.bookShop.bookShop.service.validation.userValidation;


import com.bookShop.bookShop.dto.UserDto;
import com.bookShop.bookShop.service.validation.ValidationException;

public interface UserValidationRule {

    void validate(UserDto userDto);
    default void checkNotNull(UserDto userDto) {
        if (userDto == null) {
            throw new ValidationException("User must be not null!");
        }
    }
}
