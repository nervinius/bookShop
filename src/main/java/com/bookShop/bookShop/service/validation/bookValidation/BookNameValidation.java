package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class BookNameValidation implements BookValidationRule{
    @Override
    public void validate(BookDto bookDto) {
        checkNotNull(bookDto);
        if (bookDto.getBookName() == null) {
            throw new ValidationException("Book name must not be empty");
        } else if (bookDto.getBookName().length() <= 3 || bookDto.getBookName().length() >= 20) {
            throw new ValidationException("Book name length must be longer than 3 symbols and shorter than 20 symbols!");
        }
    }
}
