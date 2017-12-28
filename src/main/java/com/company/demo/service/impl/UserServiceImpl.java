package com.company.demo.service.impl;

import com.company.demo.entity.MyUser;
import com.company.demo.repository.UserRepository;
import com.company.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private String uuid = UUID.randomUUID().toString();

    @Override
    public MyUser get(long id) {
        MyUser user = userRepository.findOne(id);
        log.info("get request for myUser {} has been sent", user);
        return user;
    }

    @Override
    public MyUser save(MyUser user) {
        log.info("myUser has been added {}", user);
        return userRepository.save(user);
    }

    @Override
    public String getUuid() {
        log.info("get request for uuid was sent. current uuid {}", uuid);
        return uuid;
    }
}
