package com.example.todolistpractice.controller;

import com.example.todolistpractice.domain.Todo;
import com.example.todolistpractice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController // @Controller + @ResponseBody 기능
@RequestMapping("/api/todos") // REST API 표준에 맞게 URL 변경
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 리스트 전체 조회 (GET /api/todos)
    @GetMapping
    public List<Todo> list() {
        return todoService.findAllTodos();
    }

    // 할 일 추가 (POST /api/todos)
    // @ModelAttribute -> @RequestBody로 변경하여 JSON 데이터를 받음
    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo) {
        todoService.createTodo(todo);
        return ResponseEntity.ok(todo); // HTTP 200 OK와 함께 생성된 객체 반환
    }

    // 할 일 삭제 (DELETE /api/todos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content 반환
    }

    // 할 일 수정 (PUT /api/todos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
        return ResponseEntity.ok(todo);
    }
}