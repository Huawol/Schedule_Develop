package com.example.tododevelop.schedules.repository;

import com.example.tododevelop.schedules.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {
}
