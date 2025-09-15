package com.example.todolistpractice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank; // 추가

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "내용을 입력해주세요.") // 할 일 내용이 비어있으면 안 됨
    private String content;
    private boolean completed;

    // 기본 생성자 (필수)
    public Todo() {
    }

    public Todo(String content, boolean completed) {
        this.content = content;
        this.completed = completed;
    }


    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
