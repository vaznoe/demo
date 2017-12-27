package com.company.demo.service;

import com.company.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee get(long id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(long id);

    List<Employee> getAll();

    List<Employee> findByPosition(String position);

    List<Employee> findByExperience(String experience);
}
