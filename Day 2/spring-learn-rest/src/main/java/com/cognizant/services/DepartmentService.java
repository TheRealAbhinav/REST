package com.cognizant.services;
import java.util.ArrayList;

import javax.transaction.Transactional;

import com.cognizant.springLearn.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    @Transactional
    public ArrayList<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }
}
