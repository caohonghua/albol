package org.caohh.albol.service.impl;

import org.caohh.albol.service.UserService;
import org.caohh.albol.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Transactional
    @Test
    void save() {
        User user = new User();
        user.setName("test");
        user.setPassword("0192023a7bbd73250516f069df18b500");
        userService.save(user);
    }
}