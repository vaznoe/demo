package com.company.demo.controller;

import com.company.demo.entity.MyUser;
import com.company.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody MyUser user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    public MyUser get(@PathVariable long id) {
        return userService.get(id);
    }

    @GetMapping("/getUuid")
    public String getUuid() {
        return userService.getUuid();
    }
}
