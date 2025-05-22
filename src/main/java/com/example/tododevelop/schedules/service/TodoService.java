package com.example.tododevelop.schedules.service;

import com.example.tododevelop.schedules.dto.TodoResponseDto;
import com.example.tododevelop.schedules.entity.Todo;
import com.example.tododevelop.schedules.repository.TodoRepository;
import com.example.tododevelop.users.entity.Users;
import com.example.tododevelop.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final UsersRepository usersRepository;
    private final TodoRepository todoRepository;

    // 게시글 생성 기능
    public TodoResponseDto save(String title, String contents, String userName) {

        Users findUser = usersRepository.findUsersByUserNameOrElseTrow(userName);

        Todo todo = new Todo(title, contents);
        todo.setUsers(findUser);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContents(),
                savedTodo.getUsers().getUserName()
        );
    }
}
