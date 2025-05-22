package com.example.tododevelop.users.service;

import com.example.tododevelop.users.dto.LoginRequestDto;
import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.dto.UsersResponseDto;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    // 생성
    public SignUpResponseDto signUp(String userName, String userEmail, String userPassword) {
        Users users = new Users(userName, userEmail, userPassword);
        if (usersRepository.findUsersByUserEmail(userEmail).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, " \uD83E\uDEF8 e-mail 중복입니다!!!");
        }
        Users saveUsers = usersRepository.save(users);
        return new SignUpResponseDto(saveUsers);
    }

    // 조회
    public UsersResponseDto findById(Long id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        // NPE 방지
        if(optionalUsers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not 존재 : " + id);
            // postman에서는 throw new를 통해서 메세지 못봄
        }
        Users findUser = optionalUsers.get();
        return new UsersResponseDto(findUser);
    }

    // 수정(비밀번호)
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Users finduser = usersRepository.findByIdOrElseThrow(id);
        if(!finduser.getUserPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"\uD83E\uDEF8 비번이 틀려요!!!!");
        }
        finduser.updatePassword(newPassword);
    }

    // 삭제
    public void delete(Long id) {
        Users findUser = usersRepository.findByIdOrElseThrow(id);
        usersRepository.delete(findUser);
    }

    // 로그인 인증
    public void login(LoginRequestDto loginRequestDto) {
        Optional<Users> userEmail = usersRepository.findUsersByUserEmail(loginRequestDto.getUserEmail());
    }
}
