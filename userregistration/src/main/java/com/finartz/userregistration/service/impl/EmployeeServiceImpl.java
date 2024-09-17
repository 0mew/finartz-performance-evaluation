package com.finartz.userregistration.service.impl;

import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.EmployeeRepository;
import com.finartz.userregistration.repository.UserTitleRepository;
import com.finartz.userregistration.request.CreateEmployeeRequest;
import com.finartz.userregistration.request.EmployeePasswdRequest;
import com.finartz.userregistration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserTitleRepository userTitleRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public Employee saveEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Integer userTitleId= createEmployeeRequest.getUserTitleId();
        UserTitle userTitle=userTitleRepository.findById(userTitleId).orElseThrow(()
                -> new ResourceNotFoundException("UserTitle not found with id: "+userTitleId));

        Employee employee= Employee.builder()
                .firstName(createEmployeeRequest.getFirstName())
                .lastName(createEmployeeRequest.getLastName())
                .email(createEmployeeRequest.getEmail())
                .userTitle(userTitle)
                .role(Role.USER)
                .active(true)
                .build();

        return employeeRepository.save(employee);
    }

    @Override
    public Employee employeeDeactivee(int employeeId) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employlee not found with id:" + employeeId));


        Employee emp=Employee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .userTitle(employee.getUserTitle())
                .paswd(employee.getPaswd())
                .role(Role.USER)
                .active(false)
                .build();

        return employeeRepository.save(emp);
    }

    @Override
    public Employee employeeActivee(int employedId) {
        Employee employee= employeeRepository.findById(employedId).orElseThrow(() -> new ResourceNotFoundException("Employlee not found with id:" + employedId));


        Employee emp=Employee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .userTitle(employee.getUserTitle())
                .paswd(employee.getPaswd())
                .role(Role.USER)
                .active(true)
                .build();

        return employeeRepository.save(emp);

    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee passwdup( int employeedid, EmployeePasswdRequest employeePasswdCreate) {

        if (employeePasswdCreate.getPasswd() == null || employeePasswdCreate.getPasswd().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        String hashedPassword = passwordEncoder.encode(employeePasswdCreate.getPasswd());
        Employee employee = employeeRepository.findById(employeedid)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setPaswd(hashedPassword);
        return employeeRepository.save(employee);
    }


}
