package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.DeleteUserResponse;
import org.dnyanyog.dto.SearchUserResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    
	@Autowired
	private Userservice userService;
	
	
	@PostMapping(path ="/AddUser")
	public UserResponse addUser(@RequestBody UserRequest request) {
		return userService.addUser(request);
		
	}
	
	
	
	@PutMapping(path = "/update/{id}")
	public UpdateUserResponse updateUser(@PathVariable("id") Integer id, @RequestBody UpdateUserRequest request) {
	    //request.setId(id);  // Set the ID from the URL path into the request body
	    return userService.updateUser(request);  // Pass the updated request to the service
	}
	
	  
	
	// Search user by ID (via URL path parameter)
    @GetMapping("/searchUser/{id}")
    public SearchUserResponse searchUser(@PathVariable("id") Integer id) {
        return userService.searchUser(id);
    }

    
    
    @DeleteMapping(path = "/deleteUser/{id}")
    public DeleteUserResponse deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

	
    /*@DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        // Call the new service method to delete the user and resequence the IDs
        userService.deleteUserAndResequence(userId);
        return "User deleted and sequence reset successfully.";
    }*/
	
	
	    
}

