package com.company.demo.service;

import com.company.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee get(long id);

    void save(Employee employee);

    Employee update(String firstName, String lastName, String experience, String position, double salary);

    void delete(long id);

    List<Employee> getAll();

    List<Employee> findByPosition(String position);

    List<Employee> findByExperience(String experience);
}
