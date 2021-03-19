package com.bookShop.bookShop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Comparable<Book> {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_author")
    private String bookAuthor;
    @Column(name = "book_price")
    private BigDecimal bookPrice;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "created")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_genre")
    private BookGenre bookGenre;

    @Override
    public int compareTo(Book book) {
        return getCreated().compareTo(book.getCreated());
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookAuthor, book.bookAuthor) &&
                Objects.equals(bookPrice, book.bookPrice) &&
                Objects.equals(user, book.user) &&
                Objects.equals(created, book.created) &&
                bookGenre == book.bookGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookAuthor, bookPrice, user, created, bookGenre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", user=" + user +
                ", created=" + created +
                ", bookGenre=" + bookGenre +
                '}';
    }
}
