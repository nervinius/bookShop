package com.bookShop.bookShop.service;

import com.bookShop.bookShop.domain.Book;
import com.bookShop.bookShop.domain.BookGenre;
import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.dto.UserDto;
import com.bookShop.bookShop.mapper.BookConverter;
import com.bookShop.bookShop.repository.bookRepository.BookRepository;
import com.bookShop.bookShop.service.validation.bookValidation.BookValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookConverter bookConverter;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookValidationService validationService;

    @Captor
    private ArgumentCaptor<BookDto> bookCaptor;

    @InjectMocks
    private BookService victim;

    @BeforeEach
    public void setup() throws Exception{
        victim = new BookService(bookRepository,validationService,bookConverter);
    }

    @Test
    public void shouldCreateUser() {
        BookDto bookDto = new BookDto();
        Book book = new Book();
        when(bookConverter.convert(bookDto)).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);

        Long result = victim.createBook(bookDto);

        verify(validationService).validate(bookCaptor.capture());
        BookDto captorResult = bookCaptor.getValue();

        assertThat(captorResult).isEqualTo(bookDto);
        assertThat(book.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindBookById() {
        when(bookRepository.findById(100L)).thenReturn(Optional.ofNullable(book()));
        when(bookConverter.convert(book())).thenReturn(bookDto());

        BookDto result = victim.findBookById(100L);

        assertThat(result).isEqualTo(bookDto());
    }

     public Book book() {
        Book book = new Book();
        book.setId(100L);
        book.setBookGenre(BookGenre.History);
        book.setBookAuthor("TEST_AUTHOR");
        return book;
     }

    public BookDto bookDto() {
        BookDto bookDto = new BookDto();
        bookDto.setId(100L);
        bookDto.setBookGenre(BookGenre.History);
        bookDto.setBookAuthor("TEST_AUTHOR");
        return bookDto;
    }
}
