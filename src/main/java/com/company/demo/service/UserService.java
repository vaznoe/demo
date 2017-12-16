package com.company.demo.service;

import com.company.demo.entity.User;

public interface UserService {

    User get(long id);

    void save(long id, String firstName, String lastName, int age);

    String getUuid();
}
