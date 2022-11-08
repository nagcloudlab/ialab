package com.example.repository;

import com.example.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {
    @Query("from Todo t where t.user.id=:userId")
    Iterable<Todo> findByUser(int userId);
}
