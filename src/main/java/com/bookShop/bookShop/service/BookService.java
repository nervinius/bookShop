package com.bookShop.bookShop.service;

import com.bookShop.bookShop.mapper.BookConverter;
import com.bookShop.bookShop.domain.Book;
import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.repository.bookRepository.BookRepository;
import com.bookShop.bookShop.service.validation.bookValidation.BookValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookValidationService bookValidationService;
    private BookConverter bookConverter;

    @Autowired
    public BookService(BookRepository bookRepository, BookValidationService bookValidationService, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookValidationService = bookValidationService;
        this.bookConverter = bookConverter;
    }

    @Transactional
    public Long createBook(BookDto bookDto) {
        bookValidationService.validate(bookDto);
        Book book = bookConverter.convert(bookDto);
        bookRepository.save(book);
        return book.getId();
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> bookConverter.convert(book))
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllSortedBooksByDate() {
        List<Book> bookListToSort = bookRepository.findAll();
        Collections.sort(bookListToSort);
        return bookListToSort.stream().map(book -> bookConverter.convert(book)).collect(Collectors.toList());
    }

    @Transactional
    public void deleteBookById(Long id) {
        bookRepository.findById(id)
                .ifPresent(bookRepository::delete);
    }

    public void updateBook(BookDto bookDto) {
        bookValidationService.validate(bookDto);
        Book book = bookConverter.convert(bookDto);
        bookRepository.save(book);
    }

    public BookDto findBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Book not found by id - " + id));
    }
}
