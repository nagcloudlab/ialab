package com.example.repository;

import com.example.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
}
