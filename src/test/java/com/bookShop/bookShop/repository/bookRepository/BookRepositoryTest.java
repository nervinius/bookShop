package com.bookShop.bookShop.repository.bookRepository;

import com.bookShop.bookShop.domain.Book;
import com.bookShop.bookShop.domain.BookGenre;
import com.bookShop.bookShop.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookRepositoryTest {

    @Autowired
    private BookRepository victim;

    @Test
    public void shouldCreateBook() {
        Book book = new Book();
        book.setBookName("TEST_NAME");
        book.setBookAuthor("TEST_AUTHOR");
        book.setBookGenre(BookGenre.History);

        Long result = victim.save(book).getId();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindUserById() {
        Book book = new Book();
        book.setBookName("TEST_NAME");
        book.setBookAuthor("TEST_AUTHOR");
        book.setBookGenre(BookGenre.History);

        Long id = victim.save(book).getId();

        Optional<Book> result = victim.findById(id);

        assertThat(result).hasValue(expectedBook(id));
    }

    @Test
    public Book expectedBook(Long id) {
        Book book = new Book();
        book.setBookName("TEST_NAME");
        book.setBookAuthor("TEST_AUTHOR");
        book.setBookGenre(BookGenre.History);
        book.setId(id);
        return book;
    }

    @Test
    public void shouldShowAllUsers() {
        Book book = new Book();
        book.setBookName("TEST_NAME");
        book.setBookAuthor("TEST_AUTHOR");
        book.setBookGenre(BookGenre.History);
        book.setUser(userForTest(2L));

        victim.save(book);

        List<Book> result = victim.findAll();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldExistsByBookName() {
        Book book = new Book();
        book.setBookName("TEST_NAME");
        book.setBookAuthor("TEST_AUTHOR");
        book.setBookGenre(BookGenre.History);
        book.setUser(userForTest(2L));

        victim.save(book);

        boolean result = victim.existsByBookName("TEST_NAME");

        assertThat(result).isTrue();
    }

    public User userForTest(Long id) {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");
        user.setId(id);
        return user;
    }
}
