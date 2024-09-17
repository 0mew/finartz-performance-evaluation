package com.finartz.userregistration.config;

import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EmployeeAdminIntializer implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public void run(String... args) throws Exception {

        if(employeeRepository.count()==0)
        {
            String hashedPassword = passwordEncoder.encode("sifre123");

            Employee adminEmployee = Employee.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("admin@admin.com")
                    .active(true)
                    .role(Role.ADMIN)
                    .paswd(hashedPassword)
                    .build();

            employeeRepository.save(adminEmployee);
        }

    }
}
