package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BookValidationService {

    private final Set<BookValidationRule> bookValidationRules;

    @Autowired
    public BookValidationService(Set<BookValidationRule> bookValidationRules) {
        this.bookValidationRules = bookValidationRules;
    }

    public void validate(BookDto bookDto) {
        bookValidationRules.forEach(s -> s.validate(bookDto));
    }
}
