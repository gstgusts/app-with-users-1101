package com.example.appwithusers1101.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserLoginDto {
    private String email;
    private String pwd;
    private String time;
}
