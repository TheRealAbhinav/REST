package com.cognizant.springLearn.controller;
import java.util.ArrayList;

import com.cognizant.services.DepartmentService;
import com.cognizant.springLearn.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/departments")
    public ArrayList<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

}
