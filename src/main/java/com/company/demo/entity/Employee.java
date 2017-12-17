package com.company.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String experience;
    private String position;
    private double salary;
}
