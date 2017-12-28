package com.company.demo.service.impl;

import com.company.demo.entity.Employee;
import com.company.demo.repository.EmployeeRepository;
import com.company.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee get(long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    @Override
    public List<Employee> findByExperience(String experience) {
        return employeeRepository.findByExperience(experience);
    }
}
