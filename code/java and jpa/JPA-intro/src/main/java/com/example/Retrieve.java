package com.example;

import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Retrieve {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        /*
            // many ways to retrieve entities
            - by primary key
            - by JPQL
            - by Criteria API
            - by Native SQL
         */

//        1. by primary key
//        Employee employee = em.find(Employee.class, 8); // Managed State
//        employee.setName("Kung-fu Panda");


        // 2. by JPQL

        Query jpql = em.createNamedQuery("Employee.findAll.byGender");
        jpql.setParameter("gen", Gender.FEMALE);
        jpql.setFirstResult(2);
        jpql.setMaxResults(2);
        List<Employee> employees=jpql.getResultList();
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        Query jpq = em.createQuery("select name,gender from Employee");
//        List<Object[]> result = jpq.getResultList();
//        for (Object[] oa : result) {
//            System.out.println(oa[0]+"\t"+oa[1].toString());
//        }

        // 3. by Criteria API
        // why we need?
        // to make dynamic queries


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
