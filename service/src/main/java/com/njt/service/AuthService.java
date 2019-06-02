package com.njt.service;

import com.njt.repo.dto.LoginFormDTO;
import com.njt.repo.dto.SignUpFormDTO;
import com.njt.repo.entity.jwt.JwtResponse;

public interface AuthService
{
	JwtResponse authenticateUser(LoginFormDTO loginRequest);
	void registerUser(SignUpFormDTO signUpRequest);
}
