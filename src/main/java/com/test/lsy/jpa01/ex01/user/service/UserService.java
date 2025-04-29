package com.test.lsy.jpa01.ex01.user.service;

import com.test.lsy.jpa01.ex01.user.domain.User;
import com.test.lsy.jpa01.ex01.user.repository.UserRepository;
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

    /**
     * 사용자 등록
     * @param user
     */
    public void saveUser(User user) {
        User newUser  = new User();
        newUser.setName(user.getName());
        newUser.setCreateDate(getNow());
        userRepository.save(newUser );
    }

    /**
     * 단일 사용자 조회
     * @param id
     * @return
     */
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 사용자 목록 조회
     * @return
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 사용자 수정
     * @param user
     */
    public void updateUser(User user) {
        User findedUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        findedUser.setName(user.getName());
        findedUser.setCreateDate(getNow());
        userRepository.save(findedUser);
    }

    /**
     * 사용자 삭제
     * @param id
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 현재시간 반환
     * @return
     */
    private static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
