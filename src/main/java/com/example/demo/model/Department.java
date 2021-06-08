package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    private int id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "manager_id")
    private int managerID;
    @Column(name = "no_employee")
    private int noEmployee;

    @OneToMany(mappedBy = "department")
    List<Employee> employees = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getNoEmployee() {
        return noEmployee;
    }

    public void setNoEmployee(int noEmployee) {
        this.noEmployee = noEmployee;
    }
}
