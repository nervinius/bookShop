package com.bookShop.bookShop.dto;

import com.bookShop.bookShop.domain.BookGenre;
import com.bookShop.bookShop.domain.User;

import java.math.BigDecimal;
import java.util.Objects;

public class BookDto {

    private Long id;
    private String bookName;
    private String bookAuthor;
    private Long user;
    private BookGenre bookGenre;
    private BigDecimal bookPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Long getUser() {
        return user;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) &&
                Objects.equals(bookName, bookDto.bookName) &&
                Objects.equals(bookAuthor, bookDto.bookAuthor) &&
                Objects.equals(user, bookDto.user) &&
                bookGenre == bookDto.bookGenre &&
                Objects.equals(bookPrice, bookDto.bookPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookAuthor, user, bookGenre, bookPrice);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", user=" + user +
                ", bookGenre=" + bookGenre +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
