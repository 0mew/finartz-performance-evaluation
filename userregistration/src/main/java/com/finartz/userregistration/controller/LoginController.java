package com.finartz.userregistration.controller;

import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.request.LoginRequest;
import com.finartz.userregistration.service.LoginSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Login")
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private LoginSevice loginSevice;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Result result = loginSevice.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(401).body(result);
        }
    }


}
