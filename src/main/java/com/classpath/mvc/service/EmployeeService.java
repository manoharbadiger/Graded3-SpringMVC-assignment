package com.classpath.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classpath.mvc.dao.EmployeeDAO;
import com.classpath.mvc.model.Employee;

 
@Service
@Transactional
public class EmployeeService{
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
 
    
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }
 
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
 
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
 
}
