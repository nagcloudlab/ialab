package com.example;

import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Employee employee = em.find(Employee.class, 8); // Managed
        em.remove(employee); // Removed State


        em.getTransaction().commit();  // Transient
        //em.getTransaction().rollback(); // Detached
        em.close();
        emf.close();

    }
}
