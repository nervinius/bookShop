package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.repository.bookRepository.BookRepository;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookUniqueNameValidation implements BookValidationRule {

    private BookRepository bookRepository;

    @Autowired
    public BookUniqueNameValidation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void validate(BookDto bookDto) {
        checkNotNull(bookDto);
        if (bookRepository.existsByBookName(bookDto.getBookName())) {
            throw new ValidationException("Book with this name already exist");
        }
    }
}
