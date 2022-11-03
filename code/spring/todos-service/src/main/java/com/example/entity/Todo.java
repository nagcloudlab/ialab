package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String title;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
