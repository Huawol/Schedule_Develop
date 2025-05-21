package com.example.tododevelop.users.repository;

import com.example.tododevelop.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
