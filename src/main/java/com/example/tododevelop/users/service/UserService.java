package com.example.tododevelop.users.service;

import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.dto.UsersResponseDto;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    // 생성
    public SignUpResponseDto signUp(String userName, String userEmail, String userPassword) {
        Users users = new Users(userName, userEmail, userPassword);
        Users saveUsers = usersRepository.save(users);
        return new SignUpResponseDto(
                saveUsers.getId(),
                saveUsers.getUserName(),
                saveUsers.getUserEmail(),
                saveUsers.getUserPassword()
        );
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
        return new UsersResponseDto(findUser.getUserName(), findUser.getUserEmail());
    }
}
