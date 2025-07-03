package org.dnyanyog.controller;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authentication {
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping(path ="/auth/login" , consumes= {"application/json", "application/xml"}, produces= {"application/json", "application/xml"})
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		
		
		return authService.login(loginRequest.getLoginName(), loginRequest.getPassword());
	}
	
}
