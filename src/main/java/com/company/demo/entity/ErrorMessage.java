package com.company.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {

    private String message;
    private LocalDateTime date;
}
