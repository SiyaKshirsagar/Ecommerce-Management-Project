package org.dnyanyog.repo;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users , Integer> {
	
	  @Query
	  (value = "ALTER TABLE users AUTO_INCREMENT = 1", nativeQuery = true)
	    void resetAutoIncrement();


	
}
