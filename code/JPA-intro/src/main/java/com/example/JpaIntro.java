package com.example;

import com.example.entity.Address;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JpaIntro {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Department department = em.find(Department.class,3);
        System.out.println(department.getName());
        System.out.println("-".repeat(10));
        department.getEmployees().forEach(e -> System.out.println(e.getName()));

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
