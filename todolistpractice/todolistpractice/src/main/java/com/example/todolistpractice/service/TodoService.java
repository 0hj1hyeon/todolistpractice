package com.example.todolistpractice.service;

import com.example.todolistpractice.domain.Todo;
import com.example.todolistpractice.repository.JpaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional // 서비스 계층에서 트랜잭션을 관리
public class TodoService {

    private final JpaTodoRepository todoRepository;

    @Autowired
    public TodoService(JpaTodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Long createTodo(Todo todo) { // 컨트롤러의 /add에 대응
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> findAllTodos() { // 컨트롤러의 /에 대응
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) { // ID로 조회
        return todoRepository.findById(id);
    }

    public void deleteTodo(Long id) { // 컨트롤러의 /delete/{id}에 대응
        todoRepository.deleteById(id);
    }

    // 이 메서드는 먼저 조회하고, 객체를 수정 후 다시 저장해야 합니다.
    public void updateTodo(Long id, Todo updateParam) { // 컨트롤러의 /update/{id}에 대응
        Optional<Todo> findTodo = todoRepository.findById(id);
        if (findTodo.isPresent()) {
            Todo todo = findTodo.get();
            todo.setContent(updateParam.getContent());
            todo.setCompleted(updateParam.isCompleted());
            // JPA는 객체의 변화를 감지하고 자동으로 UPDATE 쿼리를 날려줍니다.
        }
    }
}