package com.sparta.todoapp.controller;

import com.sparta.todoapp.dto.LoginRequestDto;
import com.sparta.todoapp.dto.ResponseDto;
import com.sparta.todoapp.dto.SignupRequestDto;
import com.sparta.todoapp.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    @PostMapping("/user/signup")
    public ResponseDto signupPage(@RequestBody @Valid SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @ResponseBody
    @PostMapping("/user/login")
    public ResponseDto login(@RequestBody @Valid LoginRequestDto requestDto, HttpServletResponse res) {
        return userService.login(requestDto, res);
    }


}