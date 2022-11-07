package com.example.repository;

import com.example.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
