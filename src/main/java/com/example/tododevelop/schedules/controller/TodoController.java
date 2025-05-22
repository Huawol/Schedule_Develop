package com.example.tododevelop.schedules.controller;


import com.example.tododevelop.schedules.dto.CreateTodoRequestDto;
import com.example.tododevelop.schedules.dto.TodoResponseDto;
import com.example.tododevelop.schedules.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 게시글 생성
    @PostMapping("/post")
    public ResponseEntity<TodoResponseDto> save(@RequestBody CreateTodoRequestDto requestDto) {
        TodoResponseDto todoResponseDto =
                todoService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUserName() /* post맨에서 회원 생성할때 만든 username이랑 같아야함*/
                );
        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

}
