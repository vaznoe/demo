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
    public Employee update(Employee employee) {
        Employee oldEmployee = employees.stream().filter(element -> employee.getId() == element.getId()).findFirst().get();
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setExperience(employee.getExperience());
        oldEmployee.setPosition(employee.getPosition());
        oldEmployee.setSalary(employee.getSalary());
        return oldEmployee;
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
