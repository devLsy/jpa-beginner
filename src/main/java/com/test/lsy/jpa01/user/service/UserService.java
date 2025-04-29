package com.test.lsy.jpa01.user.service;

import com.test.lsy.jpa01.user.domain.User;
import com.test.lsy.jpa01.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        User saveUser = new User(user.getEmail(),
                user.getName(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        User savedUser = userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findById(email).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        User findedUser = userRepository.findById(user.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        findedUser.setName(user.getName());
        userRepository.save(user);
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

}
