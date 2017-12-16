package com.company.demo.service.impl;

import com.company.demo.entity.User;
import com.company.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Scope("prototype")
@Service
public class UserServiceImpl implements UserService {

    private String uuid = UUID.randomUUID().toString();
    private List<User> users = new ArrayList<>();

    @Override
    public User get(long id) {
        User user = users.stream().filter(element -> element.getId() == id).findFirst().get();
        log.info("get request for user {} has been sent", user);
        return user;
    }

    @Override
    public void save(long id, String firstName, String lastName, int age) {
        User user = new User(id, firstName, lastName, age);
        users.add(user);
        log.info("user has been added {}", user);
    }

    @Override
    public String getUuid() {
        log.info("get request for uuid was sent. current uuid {}", uuid);
        return uuid;
    }
}
