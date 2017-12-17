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
    public void save(@RequestParam("id") long id,
                     @RequestParam("firstName") String firstName,
                     @RequestParam("lastName") String lastName,
                     @RequestParam("experience") String experience,
                     @RequestParam("position") String position,
                     @RequestParam("salary"), double salary) {
        employeeService.save(id, firstName, lastName, experience, position, salary);
    }

    @PutMapping("/put")
    public Employee update(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("experience") String experience,
                           @RequestParam("position") String position,
                           @RequestParam("salary"), double salary) {
       return employeeService.update(firstName, lastName, experience, position, salary);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/find_position")
    public List<Employee> findByPosition(@PathVariable String position) {
        return employeeService.findByPosition(position);
    }

    @GetMapping("/find_experience")
    public List<Employee> findByExperience(@PathVariable String experience) {
        return employeeService.findByExperience(experience);
    }
}
