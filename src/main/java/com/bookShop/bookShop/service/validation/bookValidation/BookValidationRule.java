package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.validation.ValidationException;

public interface BookValidationRule {

    void validate(BookDto bookDto);

    default void checkNotNull(BookDto bookDto) {
        if (bookDto == null) {
            throw new ValidationException("Book must be not null!");
        }
    }
}
