package com.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.UserCreatetDto;
import com.example.dto.UserResponseDto;
import com.example.entity.User;
import com.example.exceptions.UserExistException;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/api/users", consumes = { "application/json" })
    public ResponseEntity<?> postUser(@RequestBody UserCreatetDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user = userService.registerUser(user);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setName(user.getName());
        userResponseDto.setRoles(user.getRoles());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @ExceptionHandler(value = { UserExistException.class })
    public ResponseEntity<?> hanldeUserExistException(Throwable t) {
        HttpError httpError = new HttpError();
        httpError.setCode(HttpStatus.CONFLICT);
        httpError.setMessage(t.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(httpError);
    }

}
