package com.PractiseEmployee.Controllers;


import com.PractiseEmployee.Entity.Employee;
import com.PractiseEmployee.Exceptions.CustomException;
import com.PractiseEmployee.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeControllers {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee ){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    public ResponseEntity<Object> handleCustomeException(CustomException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable String Id) {
        try {
            Optional<Employee> employee = employeeService.getEmployeeById(Id);

            if (employee.isPresent()) {
                return ResponseEntity.ok(employee);
            } else {
                throw new CustomException(HttpStatus.NOT_FOUND, "Employee with ID " + Id + " not found");
            }

        } catch (CustomException ex) {
            return handleCustomeException(ex);
        }
    }



    @PutMapping("/{Id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable String Id,@RequestBody Employee employee){
        Employee updateEmp=employeeService.updateEmployee(Id,employee);
        return ResponseEntity.ok(updateEmp);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmpByName(@RequestParam String name){
        List<Employee> employeesByName= employeeService.searchEmployeeByName(name);
        return ResponseEntity.ok(employeesByName);
    }

    @GetMapping("/salary/total")
    public double getTotalSalary() {
        return employeeService.calculateTotalSalary();
    }
}
