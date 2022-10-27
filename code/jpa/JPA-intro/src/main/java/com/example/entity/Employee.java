package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll.byGender", query = "SELECT e FROM Employee e where e.gender=:gen")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Lob
    private String bio;
    @Lob
    private byte[] picture;

//    @Embedded
//    private Address address;

    @ElementCollection
    @CollectionTable(name = "Employee_Address", joinColumns = @JoinColumn(name ="e_id"))
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToOne(
            targetEntity = Department.class,
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "department_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
