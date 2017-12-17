package com.company.demo.service.impl;

import com.company.demo.entity.Employee;
import com.company.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private List<Employee> employees = new ArrayList<>();
    
    @Override
    public Employee get(long id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee update(String firstName, String lastName, String experience, String position, double salary) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
//                employees.stream().filter(employee2 -> employee.getId() == employee2.getId()).findFirst().get();
//        employee1.setFirstName("Stepan");
        return null;
    }

    @Override
    public void delete(long id) {
        employees.remove(employees.stream().filter(employee -> employee.getId() == id).findFirst().get());
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return employees.stream().filter(employee -> employee.getPosition().equals(position)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByExperience(String experience) {
        return employees.stream().filter(employee -> employee.getExperience().equals(experience)).collect(Collectors.toList());
    }
}
