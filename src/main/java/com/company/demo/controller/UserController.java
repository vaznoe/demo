package com.company.demo.controller;

import com.company.demo.entity.User;
import com.company.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public void save(@RequestParam("id") long id,
                     @RequestParam("firstName") String firstName,
                     @RequestParam("lastName") String lastName,
                     @RequestParam("age") int age) {
        userService.save(id, firstName, lastName, age);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @GetMapping("/getUuid")
    public String getUuid() {
        return userService.getUuid();
    }
}
