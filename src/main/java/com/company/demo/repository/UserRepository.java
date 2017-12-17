package com.company.demo.repository;

import com.company.demo.entity.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Long> {
}
