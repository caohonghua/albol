package org.caohh.albol.mapper;

import org.caohh.albol.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    void insertSelective() {
        User user = new User();
        user.setName("test");
        user.setPassword("0192023a7bbd73250516f069df18b500");
        int result = userMapper.insertSelective(user);
        assertTrue(result > 0);

    }
}