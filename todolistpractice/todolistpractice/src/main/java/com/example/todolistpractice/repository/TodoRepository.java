package com.example.todolistpractice.repository;

import com.example.todolistpractice.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional; // 값이 존재할수도 안할수도 있는 객체를 안전하게 다루기 위한 자바의 컨테이너(wrapper) 클래스
import java.util.concurrent.atomic.AtomicLong; //atomic은 원자적 연산을 보장
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private static final Map<Long, Todo> store = new HashMap<>(); // 할 일 저장
    private static final AtomicLong sequence = new AtomicLong(0L);

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(sequence.incrementAndGet()); //sequence 값을 원자적으로 1증가시켜서 id 값 설정
        }
        store.put(todo.getId(), todo);
        return todo;
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //반환값이 null 일 수 있으므로 사용되는 optional.ofnullable
    }

    public List<Todo> findAll() {
        return store.values().stream().collect(Collectors.toList()); // 스토어에 있는 값들을 리스트 형태로 변화 후 반환
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public void update(Long id, Todo updateParam) {
        Todo findTodo = store.get(id);
        if (findTodo != null) {
            findTodo.setContent(updateParam.getContent());
            findTodo.setCompleted(updateParam.isCompleted());
        }
    }
}