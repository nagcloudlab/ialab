package com.example.repository;

import com.example.entity.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodosRepository extends PagingAndSortingRepository<Todo,Integer> {
}
