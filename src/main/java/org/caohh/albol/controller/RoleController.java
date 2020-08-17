package org.caohh.albol.controller;

import org.caohh.albol.service.RoleService;
import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/search")
    public Result search(Role role){
        return roleService.search(role);
    }

    @PostMapping("/save")
    public Result save(@RequestBody  Role role){
        return roleService.save(role);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return roleService.delete(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Role role){
        return roleService.update(role);
    }
}
