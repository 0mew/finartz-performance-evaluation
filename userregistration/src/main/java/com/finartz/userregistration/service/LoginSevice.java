package com.finartz.userregistration.service;

import com.finartz.userregistration.Result.Result;

public interface LoginSevice {
     Result authenticate(String email, String rawPassword);
}
