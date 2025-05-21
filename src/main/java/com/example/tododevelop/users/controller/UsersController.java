package com.example.tododevelop.users.controller;

import com.example.tododevelop.users.dto.SignUpRequestDto;
import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto requestDto){
        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUserName(),
                        requestDto.getUserEmail(),
                        requestDto.getUserPassword()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }
}
