package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorValidation implements BookValidationRule {

    @Override
    public void validate(BookDto bookDto) {
        checkNotNull(bookDto);
        if (bookDto.getBookAuthor() == null) {
            throw new ValidationException("Book Author should be not null");
        }
    }
}
