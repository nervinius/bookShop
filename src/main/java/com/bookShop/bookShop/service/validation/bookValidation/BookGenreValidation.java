package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class BookGenreValidation implements BookValidationRule {

    @Override
    public void validate(BookDto bookDto) {
        checkNotNull(bookDto);
        if (bookDto.getBookGenre() == null) {
            throw new ValidationException("Book Genre should be not null");
        }
    }
}
