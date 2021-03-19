package com.bookShop.bookShop.repository.userRepository;


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
public class UserRepositoryTest {

    @Autowired
    private UserRepository victim;

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");

        Long result = victim.save(user).getId();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindUserById() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");

        Long id = victim.save(user).getId();

        Optional<User> result = victim.findById(id);

        assertThat(result).hasValue(expectedUser(id));
    }

    @Test
    public User expectedUser(Long id) {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");
        user.setId(id);
        return user;
    }

    @Test
    public void shouldShowAllUsers() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");

        victim.save(user);

        List<User> result = victim.findAll();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldExistByUsername() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");

        victim.save(user);

        boolean result = victim.existsByUsername("TEST_USERNAME");

        assertThat(result).isTrue();
    }

    @Test
    public void shouldExistByPassword() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");

        victim.save(user);

        boolean result = victim.existsByPassword("TEST_PASSWORD");

        assertThat(result).isTrue();
    }
}
