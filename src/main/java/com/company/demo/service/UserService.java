package com.company.demo.service;

import com.company.demo.entity.MyUser;

public interface UserService {

    MyUser get(long id);

    MyUser save(MyUser user);

    String getUuid();
}
