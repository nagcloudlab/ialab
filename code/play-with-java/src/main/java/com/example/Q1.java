package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Gender {
    MALE, FEMALE
}

enum Department {
    IT, HR, SALES, MARKETING
}

class Employee {
    private String name;
    private int age;
    private double salary;
    private Gender gender;
    private Department department;

    public Employee(String name, int age, double salary, Gender gender, Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", department=" + department +
                '}';
    }
}


public class Q1 {
    public static void main(String[] args) {

        Employee employee1 = new Employee("E1", 24, 100.00, Gender.MALE, Department.HR);
        Employee employee2 = new Employee("E2", 25, 200.00, Gender.MALE, Department.IT);
        Employee employee3 = new Employee("E3", 26, 300.00, Gender.FEMALE, Department.SALES);
        Employee employee4 = new Employee("E4", 27, 300.00, Gender.MALE, Department.SALES);
        Employee employee5 = new Employee("E5", 28, 500.00, Gender.MALE, Department.MARKETING);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        // get all employees where salary > 100 , groupingBy department
        System.out.println(
                employees
                        .stream()
                        .filter(e -> e.getSalary() > 100)
                        //.collect(Collectors.groupingBy(Employee::getDepartment))
                        .collect(Collectors.partitioningBy(e-> e.getSalary()==300))
        );

    }
}
