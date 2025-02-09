package com.codemyth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long emp_id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee() {
    }

    public Employee(Long emp_id, String name, Float salary, int age, String city) {
        this.emp_id = emp_id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
