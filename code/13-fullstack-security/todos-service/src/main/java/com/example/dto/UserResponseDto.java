package com.example.dto;

import java.util.List;

import com.example.entity.Role;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private String name;
    private List<Role> roles;

}
