package com.test.lsy.jpa01.ex01.service;

import com.test.lsy.jpa01.ex01.domain.User;
import com.test.lsy.jpa01.ex01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        User newUser  = new User();
        newUser.setName(user.getName());
        newUser.setCreateDate(getNow());
        userRepository.save(newUser );
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Long id, User user) {
        User findedUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        findedUser.setName(user.getName());
        return findedUser;
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
