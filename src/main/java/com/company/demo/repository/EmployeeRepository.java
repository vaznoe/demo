package com.company.demo.repository;

import com.company.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByPosition(String position);

    List<Employee> findByExperience(String experience);
}
