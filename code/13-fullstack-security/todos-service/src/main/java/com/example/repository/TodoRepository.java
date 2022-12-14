package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("from Todo t where t.user.id = :userId")
    List<Todo> findByUserId(Long userId);

}
