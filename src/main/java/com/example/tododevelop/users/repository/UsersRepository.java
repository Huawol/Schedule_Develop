package com.example.tododevelop.users.repository;

import com.example.tododevelop.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByUserName(String username);

    default Users findUsersByUserNameOrElseTrow(String username) {
        return findUsersByUserName(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND
                        )
                );

    }

    default Users findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND
                        )
                );
    }
}
