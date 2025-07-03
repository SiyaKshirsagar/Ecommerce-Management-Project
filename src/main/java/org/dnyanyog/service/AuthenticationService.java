package org.dnyanyog.service;

import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Login;
import org.dnyanyog.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private LoginRepo loginRepo;

    public LoginResponse login(String loginName, String password) {
        LoginResponse response = new LoginResponse();

        if (loginName == null || password == null) {
            response.setResponseCode("0911");
            response.setResponseMessage("Login name and Password both are mandatory");
            return response;
        }

        try {
            // Trim the inputs to remove any accidental leading/trailing spaces
            loginName = loginName.trim();
            password = password.trim();

            // Log the login name and password received from the request
            System.out.println("Login Attempt: " + loginName + " - " + password);

            // Check if the user exists in the database
            Login loginFromDb = loginRepo.findByLoginNameAndPassword(loginName, password);

            if (loginFromDb != null) {
                // Print the Login object for debugging
                System.out.println("Login found in DB: " + loginFromDb);

                response.setResponseCode("0000");
                response.setResponseMessage("Login Successful");
                return response;
            } else {
                // If no match, return a failure message
                response.setResponseCode("0911");
                response.setResponseMessage("User and password does not match");
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseCode("0911");
            response.setResponseMessage("Internal server error occurred. Contact admin");
            return response;
        }
    }
}
