package com.example.todolistpractice.repository;

import com.example.todolistpractice.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TodoRepository 상속을 제거하고, JpaRepository만 상속합니다.
public interface JpaTodoRepository extends JpaRepository<Todo, Long> {
    // 이제 JpaRepository가 제공하는 메서드(save, findById 등)만 사용합니다.
}