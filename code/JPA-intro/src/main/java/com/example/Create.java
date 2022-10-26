package com.example;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Create {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();   // New / Transient
        employee.setName("Pov");
        employee.setGender(Gender.MALE);
        Department department = new Department();
        department.setId(3);
        employee.setDepartment(department);

        em.persist(employee);  // Managed / Persistence State

        employee.setGender(Gender.MALE);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
