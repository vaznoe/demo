package com.company.demo.controller;

import com.company.demo.entity.Employee;
import com.company.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee get(@PathVariable long id) {
        return employeeService.get(id);
    }

    @PostMapping("/add")
    public Employee save(@RequestBody Employee employee) {
       return employeeService.save(employee);
    }

    @PutMapping("/put")
    public Employee update(@RequestBody Employee employee) {
       return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/find_by_position/{position}")
    public List<Employee> findByPosition(@PathVariable String position) {
        return employeeService.findByPosition(position);
    }

    @GetMapping("/find_by_experience/{experience}")
    public List<Employee> findByExperience(@PathVariable String experience) {
        return employeeService.findByExperience(experience);
    }
}
