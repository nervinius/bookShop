package com.bookShop.bookShop.controller;

import com.bookShop.bookShop.dto.BookDto;
import com.bookShop.bookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/createTask")
    public ResponseEntity<Long> createBook(@RequestBody BookDto bookDto) {
        Long id = bookService.createBook(bookDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/getSortedBooks/{id}")
    public List<BookDto> getSortedBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/updateBook/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        bookDto.setId(id);
        bookService.updateBook(bookDto);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }
}
