package com.PractiseEmployee.Services;


import com.PractiseEmployee.Entity.Department;
import com.PractiseEmployee.Repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepo departmentRepo;

    public Department createDept(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getDept(){
        return departmentRepo.findAll();
    }

    public Optional<Department> getByDeptId(String Id){
        return departmentRepo.findById(Id);
    }
}
