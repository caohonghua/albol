package org.caohh.albol.service;

import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Result search(Role role);
    Result save(Role role);
    Result delete(Long id);
    Result update(Role role);
}
