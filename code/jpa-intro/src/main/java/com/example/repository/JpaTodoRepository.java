package com.example.repository;


import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaTodoRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");

    // C
    public void save(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(todo);
        entityManager.close();
    }

    // R
    public List<Todo> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Todo> todos = entityManager.createQuery("from Todo").getResultList();
        entityManager.close();
        return todos;
    }


}
