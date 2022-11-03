package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String title;
    private boolean completed;
//    private LocalDate date;
//    private List<String> tags;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
