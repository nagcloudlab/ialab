package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;

    @OneToMany(
            mappedBy = "department",
            targetEntity = Employee.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Employee> employees = new ArrayList<>();


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
