package com.example.todolistpractice.service;

import com.example.todolistpractice.domain.Todo;
import com.example.todolistpractice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Long createTodo(Todo todo) { // todo생성
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> findAllTodos() { // 모든 todo 찾기
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) { // 아이디를 통해 찾기
        return todoRepository.findById(id);
    }

    public void deleteTodo(Long id) { // 삭제
        todoRepository.deleteById(id);
    }

    public void updateTodo(Long id, Todo todo) { // 수정
        todoRepository.update(id, todo);
    }
}