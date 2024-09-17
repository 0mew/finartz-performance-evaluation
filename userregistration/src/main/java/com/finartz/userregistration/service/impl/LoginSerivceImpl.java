package com.finartz.userregistration.service.impl;

import com.finartz.userregistration.Message.Messages;
import com.finartz.userregistration.Result.ErrorResult;
import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.Result.SuccessResult;
import com.finartz.userregistration.entity.Employee;
import com.finartz.userregistration.entity.Role;
import com.finartz.userregistration.repository.EmployeeRepository;
import com.finartz.userregistration.service.LoginSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginSerivceImpl implements LoginSevice {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Result authenticate(String email, String rawPassword) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(employee.isActive()==true)
        {
            if (passwordEncoder.matches(rawPassword, employee.getPaswd())==true)
            {
                if (employee.getRole()== Role.ADMIN) {
                    //admin girişi sağlandı
                    return new SuccessResult(Messages.AdminLogin);
                }
                else {
                    // çalışan girişi sağlandı
                    return new SuccessResult(Messages.EmployeeLogin);
                }
            }
            else {
                return new ErrorResult(Messages.UserNotFound);
            }
        }
        else {
            return new ErrorResult(Messages.UserIsInactive);
        }





    }

}
