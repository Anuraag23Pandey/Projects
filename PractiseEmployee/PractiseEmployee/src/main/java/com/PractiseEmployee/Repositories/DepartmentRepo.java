package com.PractiseEmployee.Repositories;

import com.PractiseEmployee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,String> {
}
