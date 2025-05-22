package com.example.tododevelop.schedules.repository;

import com.example.tododevelop.schedules.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    default Todo findTodoByOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND)
        );
    }
}
