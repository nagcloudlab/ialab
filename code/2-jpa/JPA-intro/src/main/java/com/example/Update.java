package com.example;

import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        // Req-1
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, 8);
        em.getTransaction().commit();
        em.close();

        employee.setName("POV"); // Detached

        // Req-2
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(employee);  // Managed
        em.getTransaction().commit();
        em.close();


        emf.close();

    }
}
