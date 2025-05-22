package com.example.tododevelop.schedules.controller;


import com.example.tododevelop.schedules.dto.CreateTodoRequestDto;
import com.example.tododevelop.schedules.dto.TodoResponseDto;
import com.example.tododevelop.schedules.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();

        return new ResponseEntity<>(todoResponseDtoList, HttpStatus.OK);
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findById(@PathVariable Long id) {
        TodoResponseDto todoResponseDto = todoService.findById(id);
        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<TodoResponseDto> delete(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
