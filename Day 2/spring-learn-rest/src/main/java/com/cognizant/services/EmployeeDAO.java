package com.cognizant.services;

import com.cognizant.springLearn.entity.Employee;
import com.cognizant.springLearn.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;

@Repository
public class EmployeeDAO {

    private ArrayList<Employee> employeeList;
    public EmployeeDAO() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        employeeList = context.getBean("employeeList", ArrayList.class);
    }
    //This method returns the EmployeeList
    public ArrayList<Employee> getAllEmployees(){
        return employeeList;
    }
    //Find employee by Id
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        for(Employee employee: employeeList) {
            if(employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with id: " + id + " not found!!");
    }
    //Update employee based on id
    public void updateEmployee(int id, @Valid Employee employee) throws EmployeeNotFoundException {
        for(Employee employees: employeeList) {
            if(employees.getId() == id) {
                employees.setId(employee.getId());
                employees.setName(employee.getName());
                employees.setPermanent(employee.isPermanent());
                employees.setSalary(employee.getSalary());
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not present with id: " + id);
    }
    //Delete employee based on id
    public ArrayList<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
        for(Employee employees: employeeList) {
            if(id == employees.getId()) {
                employeeList.removeIf(t -> t.getId() == id);
                return employeeList;
            }
        }
        throw new EmployeeNotFoundException("Cannot Delete!! Employee not present with id: " + id);
    }

}
