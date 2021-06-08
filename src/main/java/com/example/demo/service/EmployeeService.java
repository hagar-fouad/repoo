package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public ResponseEntity<Employee> getCustomerById(int employeeID ){
        Optional<Employee> employee = employeeRepository.findById(employeeID);
        if(employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int employeeID, Employee emp) {
        Employee employee = employeeRepository.findById(employeeID).get();
        employee.setName(emp.getName());
        employee.setJobTitle(emp.getJobTitle());
        employee.setSalary(emp.getSalary());
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }


    public ResponseEntity<?> deleteEmployee( int employeeID) {
        Employee employee = employeeRepository.findById(employeeID).get();
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
