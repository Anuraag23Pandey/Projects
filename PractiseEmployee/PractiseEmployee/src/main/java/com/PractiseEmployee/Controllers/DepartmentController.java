package com.PractiseEmployee.Controllers;


import com.PractiseEmployee.Entity.Department;
import com.PractiseEmployee.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/Dept")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Department> createDept(@RequestBody Department department){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDept(department));
    }


    @GetMapping
    public ResponseEntity<List<Department>> getDept(){
        return ResponseEntity.ok(departmentService.getDept());
    }

    @GetMapping("/Id")
    public ResponseEntity<Optional<Department>>  getByDeptId(@PathVariable String Id){
        return ResponseEntity.ok(departmentService.getByDeptId(Id));

    }

}
