/**
 * @author Sameer Balehosur
 *
 * 
 */
package com.testyantra.sastaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testyantra.sastaapp.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
//	@Query(value = "select * from user where status='Pending'",nativeQuery = true)
//	public User getApprovedPosts();

}
