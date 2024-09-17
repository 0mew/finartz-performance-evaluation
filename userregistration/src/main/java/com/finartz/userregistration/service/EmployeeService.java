package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.request.EmployeePasswdRequest;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(CreateEmployeeRequest createEmployeeRequest);
    Employee employeeDeactivee(int employedId);
    Employee employeeActivee(int employedId);
    List<Employee> getAll();
     Employee passwdup( int employeedid, EmployeePasswdRequest employeePasswdCreate);
}
