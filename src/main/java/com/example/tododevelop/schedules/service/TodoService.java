package com.example.tododevelop.schedules.service;

import com.example.tododevelop.schedules.dto.TodoResponseDto;
import com.example.tododevelop.schedules.entity.Todo;
import com.example.tododevelop.schedules.repository.TodoRepository;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final UsersRepository usersRepository;
    private final TodoRepository todoRepository;

    // 게시글 생성 기능
    public TodoResponseDto save(String title, String contents, Long userId) {

        Users findUser = usersRepository.findByIdOrElseThrow(userId);

        Todo todo = new Todo(title, contents);
        todo.setUsers(findUser);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo);
    }

    // 게시글 전체 조회 기능
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDto::toDto)
                .toList();
    }

    // 게시글 단건 조회
    public TodoResponseDto findById(Long id) {
        Todo findTodo = todoRepository.findTodoByOrElseThrow(id);
        return new TodoResponseDto(findTodo);
    }

    // 게시글 수정
    @Transactional
    public TodoResponseDto updateTodo(Long id, String newContents) {
        Todo findTodo = todoRepository.findTodoByOrElseThrow(id);
        findTodo.updateContents(newContents);

        return new TodoResponseDto(findTodo);
    }

    // 게시글 삭제
    public void delete(Long id) {
        Todo findTodo = todoRepository.findTodoByOrElseThrow(id);
        todoRepository.delete(findTodo);
    }
}




