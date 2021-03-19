package com.bookShop.bookShop.service.validation.bookValidation;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class BookPriceValidation implements BookValidationRule {
    @Override
    public void validate(BookDto bookDto) {
        checkNotNull(bookDto);
        if (bookDto.getBookPrice().compareTo(new BigDecimal(BigInteger.ZERO)) == 0 || bookDto.getBookPrice().compareTo(new BigDecimal(BigInteger.ZERO)) < 0) {
            throw new ValidationException("Book price must be more than 0");
        }

    }
}
