package com.example.tododevelop.users.repository;

import com.example.tododevelop.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UsersRepository extends JpaRepository<Users, Long> {

    default Users findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
