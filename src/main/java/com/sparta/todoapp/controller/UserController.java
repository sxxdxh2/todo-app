package com.sparta.todoapp.controller;

import com.sparta.todoapp.dto.ResponseDto;
import com.sparta.todoapp.dto.SignupRequestDto;
import com.sparta.todoapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    @GetMapping("/user/signup")
    public ResponseDto signupPage(@RequestBody @Valid SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }



}