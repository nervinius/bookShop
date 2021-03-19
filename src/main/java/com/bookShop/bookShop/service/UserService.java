package com.bookShop.bookShop.service;

import com.bookShop.bookShop.mapper.UserConverter;
import com.bookShop.bookShop.domain.User;
import com.bookShop.bookShop.dto.UserDto;
import com.bookShop.bookShop.repository.userRepository.UserRepository;
import com.bookShop.bookShop.service.validation.userValidation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserValidationService userValidationService;
    private UserConverter userConverter;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserValidationService userValidationService, UserConverter userConverter, UserRepository userRepository) {
        this.userValidationService = userValidationService;
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Transactional
    public Long createUser(UserDto userDto) {
        userValidationService.validate(userDto);
        User user = userConverter.convert(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userConverter.convert(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.findById(id)
                .ifPresent(userRepository::delete);
    }

    public void userUpdate(UserDto userDto) {
        User user = userConverter.convert(userDto);
        userRepository.save(user);
    }

    public UserDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(userConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("No user found by id : " + id));
    }
}
