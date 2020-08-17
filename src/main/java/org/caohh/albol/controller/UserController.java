package org.caohh.albol.controller;

import org.caohh.albol.service.UserService;
import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public Result search(User user) {
        return userService.search(user);
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/reg")
    public Result reg(@RequestBody User user) {
        return userService.reg(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/logout")
    public Result logout(@RequestHeader("X-Token") String token){
        return userService.logout(token);
    }

    @GetMapping("/info")
    public Result info(@RequestHeader("X-Token") String token){
        return userService.info(token);
    }
}
