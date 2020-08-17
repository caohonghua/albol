package org.caohh.albol.service;

import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Result search(User user);

    Result save(User user);

    Result delete(Long id);

    Result update(User user);

    Result reg(User user);

    Result login(User user);

    Result logout(String token);

    Result info(String token);
}
