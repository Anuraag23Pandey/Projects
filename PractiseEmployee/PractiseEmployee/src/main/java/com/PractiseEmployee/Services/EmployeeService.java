package com.PractiseEmployee.Services;


import com.PractiseEmployee.Entity.Employee;
import com.PractiseEmployee.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee saveEmployee(Employee employee){
        String empId= UUID.randomUUID().toString();
        employee.setId(empId);
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(String Id){
        return employeeRepo.findById(Id);
    }


    public Employee updateEmployee(String Id, Employee employee){
        if(employeeRepo.existsById(Id)){
            employee.setId(Id);
            employeeRepo.save(employee);
        }
        return employeeRepo.save(employee);
    }


    public List<Employee> searchEmployeeByName(@PathVariable String value){
        return employeeRepo.findByNameContainingIgnoreCase(value);
    }

    public double calculateTotalSalary() {
        return employeeRepo.findAll().stream().mapToDouble(Employee::getSalary).sum();
    }
}
