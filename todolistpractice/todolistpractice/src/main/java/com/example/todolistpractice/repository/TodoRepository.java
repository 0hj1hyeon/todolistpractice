package com.example.todolistpractice.repository;

import com.example.todolistpractice.domain.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findById(Long id);
    List<Todo> findAll();
    void update(Long id, Todo todo);
    void deleteById(Long id);
}