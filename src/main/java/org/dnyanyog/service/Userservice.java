package org.dnyanyog.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.DeleteUserResponse;
import org.dnyanyog.dto.SearchUserResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
public class Userservice {
	
	
	@Autowired
	UserRepo userRepo;

	public UserResponse addUser(UserRequest request) {
		
		Users userTable =new Users();
		
		userTable.setName(request.getName());
		userTable.setEmail(request.getEmail());
		userTable.setPassword(request.getPassword());
		
		Users datainsertedByRepoIncludingGeneratedValue = userRepo.save(userTable);
		
		UserResponse response = new UserResponse();
		
		response.setResponseCode("0000");
		response.setResponseMessage("user added succesfully");
		response.setRequest(request);
		
		response.setId(datainsertedByRepoIncludingGeneratedValue.getId());
		
		return response;
	}
	

	public UpdateUserResponse updateUser(UpdateUserRequest request) {
	    // Find the user by ID (from the request body)
	    /*Users existingUser = userRepo.findById(request.getId()).orElse(null);
	    
	    UpdateUserResponse response = new UpdateUserResponse();

	    // If the user is not found, return an error response
	    if (existingUser == null) {
	        response.setResponseCode("0001");
	        response.setResponseMessage("User not found with ID: " + request.getId());
	        response.setRequest(request);
	        return response;
	    }

	    // Update the user details
	    existingUser.setName(request.getName());
	    existingUser.setEmail(request.getEmail());
	    existingUser.setPassword(request.getPassword());

	    // Save the updated user
	    userRepo.save(existingUser);

	    // Return a success response
	    response.setResponseCode("0000");
	    response.setResponseMessage("User updated successfully");
	    response.setRequest(request);
	    return response; */
		
		 Optional<Users> existingUserOptional = userRepo.findById(request.getId());

		    UpdateUserResponse response = new UpdateUserResponse();

		    if (existingUserOptional.isPresent()) {
		        Users existingUser = existingUserOptional.get();
		        existingUser.setName(request.getName());
		        existingUser.setEmail(request.getEmail());
		        existingUser.setPassword(request.getPassword());

		        userRepo.save(existingUser);

		        response.setResponseCode("0000");
		        response.setResponseMessage("User updated successfully");
		        response.setRequest(request);
		    } else {
		        response.setResponseCode("1001");
		        response.setResponseMessage("User not found");
		        response.setRequest(request);
		    }

		    return response;
		
		
		}


    // Search user by ID (received as a URL path parameter)
    public SearchUserResponse searchUser(Integer id) {
        SearchUserResponse response = new SearchUserResponse();
        
        // Try to find the user by ID
        Users user = userRepo.findById(id).orElse(null);
        
        if (user != null) {
            response.setResponseCode("0000");
            response.setResponseMessage("User found successfully");
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setPassword(user.getPassword());
        } else {
            response.setResponseCode("1001");
            response.setResponseMessage("User not found");
        }
        
        return response;
    }
    
    //Delete user but not in sequence
    public DeleteUserResponse deleteUser(Integer id) {
        DeleteUserResponse response = new DeleteUserResponse();

        // Check if the user exists
        if (userRepo.existsById(id)) {
            // Delete the user
            userRepo.deleteById(id);
            response.setResponseCode("0000");
            response.setResponseMessage("User deleted successfully");
        } else {
            response.setResponseCode("1001");
            response.setResponseMessage("User not found");
        }

        return response;
    }
    
 /* Updated method to delete the user and resequence
    @Transactional
    public void deleteUserAndResequence(Integer id) {
        // Delete the user by ID
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);

            // Reset the auto-increment for the 'Users' table (MySQL example)
            resetAutoIncrement();

            // Re-sequence the remaining users (adjust their IDs)
            resequenceUsers();
        }
    }

    private void resetAutoIncrement() {
        // Reset the auto-increment counter to start from 1 (MySQL example)
        userRepo.resetAutoIncrement();  // Ensure you have this query in the UserRepo interface
    }

    private void resequenceUsers() {
        List<Users> users = userRepo.findAll();
        int newId = 1;
        for (Users user : users) {
            user.setId(newId);  // Set new ID
            userRepo.save(user);  // Save user with new ID
            newId++;
        }
    }*/
}

    
