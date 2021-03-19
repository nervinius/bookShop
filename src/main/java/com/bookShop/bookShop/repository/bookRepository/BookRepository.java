package com.bookShop.bookShop.repository.bookRepository;

import com.bookShop.bookShop.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByBookName(String name);
}
