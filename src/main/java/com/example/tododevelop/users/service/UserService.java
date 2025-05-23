package com.example.tododevelop.users.service;

import com.example.tododevelop.config.PasswordEncoder;
import com.example.tododevelop.exception.CustomException;
import com.example.tododevelop.exception.ExceptionStatus;
import com.example.tododevelop.users.dto.LoginRequestDto;
import com.example.tododevelop.users.dto.SignUpResponseDto;
import com.example.tododevelop.users.dto.UsersResponseDto;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    // 생성
    public SignUpResponseDto signUp(String userName, String userEmail, String userPassword) {
        Users users = new Users(userName, userEmail, passwordEncoder.encode(userPassword));
        if (usersRepository.findUsersByUserEmail(userEmail).isPresent()){
            throw new CustomException(ExceptionStatus.USEREMAIL_iS_EXIST);
        }
        Users saveUsers = usersRepository.save(users);
        return new SignUpResponseDto(saveUsers);
    }

    // 조회
    public UsersResponseDto findById(Long id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        // NPE 방지
        if(optionalUsers.isEmpty()) {
            throw new CustomException(ExceptionStatus.USER_IS_NOT_EXIST);
        }
        Users findUser = optionalUsers.get();
        return new UsersResponseDto(findUser);
    }

    // 수정(비밀번호)
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Users finduser = usersRepository.findByIdOrElseThrow(id);
        if(!passwordEncoder.matches(oldPassword, finduser.getUserPassword())) {
            throw new CustomException(ExceptionStatus.PASSWORDS_DO_NOT_MATCH);
        }
        finduser.updatePassword(passwordEncoder.encode(newPassword));
    }

    // 삭제
    public void delete(Long id) {
        Users findUser = usersRepository.findByIdOrElseThrow(id);
        usersRepository.delete(findUser);
    }

    // 로그인 인증
    public UsersResponseDto login(LoginRequestDto loginRequestDto) {
        Users finduser = usersRepository.findUsersByUserEmailOrElseTrow(loginRequestDto.getUserEmail());
        if(!passwordEncoder.matches(loginRequestDto.getUserPassword(), finduser.getUserPassword())) {
            throw new CustomException(ExceptionStatus.PASSWORDS_DO_NOT_MATCH);
        }
        return new UsersResponseDto(finduser);
    }
}
