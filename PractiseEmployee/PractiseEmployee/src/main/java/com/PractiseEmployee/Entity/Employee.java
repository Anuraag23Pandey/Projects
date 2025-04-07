package com.PractiseEmployee.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    private String id;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "email", columnDefinition = "TEXT")
    private String email;

    @Column(name = "salary")
    private Double salary;

    // ✅ Owning side
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dept_id", referencedColumnName = "id")
    @JsonManagedReference
    private Department department;

    // Constructors
    public Employee() {}

    public Employee(String name, String email, Department department, Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
