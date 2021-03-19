package com.bookShop.bookShop.mapper;

import com.bookShop.bookShop.domain.Book;
import com.bookShop.bookShop.domain.User;
import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.repository.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BookConverter {

    private UserRepository userRepository;

    @Autowired
    public BookConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookName(bookDto.getBookName());
        book.setBookAuthor(bookDto.getBookAuthor());
        book.setBookGenre(bookDto.getBookGenre());
        book.setBookPrice(bookDto.getBookPrice());
        book.setUser(userRepository.findById(bookDto.getUser()).orElseThrow(() -> new NoSuchElementException("No user found by id : " + bookDto.getUser())));
        return book;
    }

    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookName(book.getBookName());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setBookGenre(book.getBookGenre());
        bookDto.setBookPrice(book.getBookPrice());
        bookDto.setUser(book.getUser().getId());
        return bookDto;
    }
}
