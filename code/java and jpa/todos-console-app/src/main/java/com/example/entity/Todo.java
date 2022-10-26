package com.example.entity;

public class Todo {

    private int id;
    private String title;
    private boolean completed;
    private TodoType type;

    private User user;

    public Todo(){}

    public Todo(int id, String title, boolean completed, TodoType type) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoType getType() {
        return type;
    }

    public void setType(TodoType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", type=" + type +
                '}';
    }
}
