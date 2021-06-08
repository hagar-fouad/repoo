package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public ResponseEntity<Department> getDepartmentById(int departmentID) {
        Optional<Department> department = departmentRepository.findById(departmentID);
        if (department.isPresent()) {
            return ResponseEntity.ok().body(department.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }


    public Department updateDepartment(int departmentID, Department dept) {

        Department department = departmentRepository.findById(departmentID).get();
        department.setDepartmentName(dept.getDepartmentName());
        department.setManagerID(dept.getManagerID());
        department.setNoEmployee(dept.getNoEmployee());
        Department updatedDepartment = departmentRepository.save(department);
        return updatedDepartment;
    }


    public ResponseEntity<?> deleteDepartment(int departmentID) {
        Department department = departmentRepository.findById(departmentID).get();
        departmentRepository.delete(department);
        return ResponseEntity.ok().build();
    }
}
