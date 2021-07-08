package com.cognizant.services;

import com.cognizant.springLearn.entity.Employee;
import com.cognizant.springLearn.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
    @Transactional
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        return employeeDao.getEmployeeById(id);
    }
    @Transactional
    public void updateEmployee(int id, @Valid Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(id, employee);
    }
    @Transactional
    public ArrayList<Employee> deleteEmployee(int id) throws EmployeeNotFoundException{
        return employeeDao.deleteEmployee(id);
    }

}
