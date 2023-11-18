package com.sparta.todoapp.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequestDto {
    @Size(min = 4, max = 10, message = "4~10자 사이로 입력하세요.")
    @Pattern(regexp = "^[a-z0-9]*$", message = "알파벳 소문자, 숫자로 구성되어야 합니다.")
    private String username;

    @Size(min = 8, max = 15, message = "8~15자 사이로 입력하세요.")
    @Pattern(regexp="^[a-zA-Z0-9]*$", message="알파벳 대소문자, 숫자로 구성되어야 합니다.")
    private String password;

    private boolean admin = false;
    private String adminToken = "";
}