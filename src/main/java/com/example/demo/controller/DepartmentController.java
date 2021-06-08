package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") int departmentID) {
        return departmentService.getDepartmentById(departmentID);
    }

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {

        return departmentService.createDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable(value = "id") int departmentID,
                                       @RequestBody Department dept) {
        return departmentService.updateDepartment(departmentID, dept);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id") int departmentID) {
        return departmentService.deleteDepartment(departmentID);
    }

}
