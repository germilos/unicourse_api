package com.njt.service.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.njt.repo.RoleRepository;
import com.njt.repo.UserRepository;
import com.njt.repo.dto.LoginFormDTO;
import com.njt.repo.dto.SignUpFormDTO;
import com.njt.repo.entity.Role;
import com.njt.repo.entity.User;
import com.njt.repo.entity.jwt.JwtResponse;
import com.njt.repo.enumeration.RoleName;
import com.njt.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService
{
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtProvider;
	
	public JwtResponse authenticateUser(LoginFormDTO loginRequest) {

		System.out.println("Finished auth");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
						loginRequest.getPassword()));
		System.out.println("Finished auth");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());
	}
	
	public void registerUser(SignUpFormDTO signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new RuntimeException("User with that username exists!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new RuntimeException("User with that email exists!");
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		List<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
	}
}
