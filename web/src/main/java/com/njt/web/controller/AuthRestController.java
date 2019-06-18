package com.njt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.dto.LoginFormDTO;
import com.njt.repo.dto.SignUpFormDTO;
import com.njt.repo.entity.jwt.JwtResponse;
import com.njt.service.security.AuthServiceImpl;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthRestController
{

	private AuthServiceImpl authService;

	@Autowired
	public AuthRestController(AuthServiceImpl authService)
	{
		this.authService = authService;
	}

	@PostMapping("/signin")
	public JwtResponse authenticate(@RequestBody LoginFormDTO loginRequest)
	{
		System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
		return authService.authenticateUser(loginRequest);
	}

	@PostMapping("/signup")
	public void register(@RequestBody SignUpFormDTO signUpRequest)
	{
		System.out.println("Signup username: " + signUpRequest.getUsername());
		authService.registerUser(signUpRequest);
	}

}
