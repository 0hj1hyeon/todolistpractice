package com.example.todolistpractice.domain;

public class Todo {
    private Long id; // 아이디
    private String content; // 내가 입력한 할 일
    private boolean completed; // 할 일의 완료 여부

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
