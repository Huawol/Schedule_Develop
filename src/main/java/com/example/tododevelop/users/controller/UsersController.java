package com.example.tododevelop.users.controller;

import com.example.tododevelop.users.dto.SignUpRequestDto;
import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.dto.UpdatePasswordRequstDto;
import com.example.tododevelop.users.dto.UsersResponseDto;
import com.example.tododevelop.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUserName(),
                        requestDto.getUserEmail(),
                        requestDto.getUserPassword()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

    //특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> findById(@PathVariable Long id) {
        UsersResponseDto usersResponseDto = userService.findById(id);
        return new ResponseEntity<>(usersResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequstDto requstDto
    ) {
        userService.updatePassword(id, requstDto.getOldPassword(), requstDto.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
