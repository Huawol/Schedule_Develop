package com.example.tododevelop.users.service;

import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public SignUpResponseDto signUp(String userName, String userEmail, String userPassword) {
        Users users = new Users(userName, userEmail, userPassword);
        Users saveUsers = usersRepository.save(users);
        return new SignUpResponseDto(saveUsers.getId(),saveUsers.getUserName(), saveUsers.getUserEmail(), saveUsers.getUserPassword());
    }
}
