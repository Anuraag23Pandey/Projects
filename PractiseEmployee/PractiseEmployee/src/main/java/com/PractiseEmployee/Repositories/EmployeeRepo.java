package com.PractiseEmployee.Repositories;

import com.PractiseEmployee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    List<Employee> findByNameContainingIgnoreCase(String name);

}
