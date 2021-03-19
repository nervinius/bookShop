package com.bookShop.bookShop.repository.userRepository;

import com.bookShop.bookShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPassword(String password);

    boolean existsByUsername(String username);
}
