package com.example.tododevelop.users.controller;

import com.example.tododevelop.users.dto.*;
import com.example.tododevelop.users.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody @Validated SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUserName(),
                        requestDto.getUserEmail(),
                        requestDto.getUserPassword()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<Void> login(HttpSession session, @RequestBody @Valid LoginRequestDto loginRequestDto) {
        UsersResponseDto login = userService.login(loginRequestDto);
        session.setAttribute("userEmail",login.getUserEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> findById(@PathVariable Long id) {
        UsersResponseDto usersResponseDto = userService.findById(id);
        return new ResponseEntity<>(usersResponseDto, HttpStatus.OK);
    }

    // 비밀번호 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequstDto requstDto
    ) {
        userService.updatePassword(id, requstDto.getOldPassword(), requstDto.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
