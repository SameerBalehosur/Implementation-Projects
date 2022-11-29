package com.testyantra.sastaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.sastaapp.entity.User;
import com.testyantra.sastaapp.response.UserResponse;
import com.testyantra.sastaapp.service.UserServiceImpl;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@RestController
@RequestMapping("/apis/sasta/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	/** User Registration */
	@PostMapping("/registration")
	public ResponseEntity<?> userRegistration(@RequestBody User user) {
		UserResponse userProfile = userServiceImpl.userRegistration(user);
		if (userProfile != null) {
			return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/** User Login*/
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody  User user) {
		UserResponse userLogin = userServiceImpl.userLogin(user);
		if (userLogin != null) {
			return new ResponseEntity<>(userLogin, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/** Getting User Profile Details */
	@GetMapping("/settings/profile")
	public ResponseEntity<?> userProfile(@RequestParam Long userId) {
		UserResponse userProfile = userServiceImpl.userProfile(userId);
		if (userProfile != null) {

			return new ResponseEntity<>(userProfile, HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/** Getting All posts which is done by single users */
	@GetMapping("/all/posts/indiuals")
	public ResponseEntity<?> getAllPosts(@RequestBody User user) {
		UserResponse allPosts = userServiceImpl.getAllPosts(user);
		if (!allPosts.getPostsPojosList().isEmpty()) {
			return new ResponseEntity<>(allPosts, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	/** Getting All posts which is done by all users */
	@GetMapping("/all/posts/others")
	public ResponseEntity<?> getAllPostsToUser() {
		UserResponse allPosts = userServiceImpl.getAllPostsToUsers();
		if (!allPosts.getPostsPojosList().isEmpty()) {
			return new ResponseEntity<>(allPosts, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/** Getting User Approved Posts by Publisher */
	@GetMapping("/approved/posts")
	public ResponseEntity<?> userApprovedPost(@RequestParam Long id) {
		UserResponse userApprovedPosts = userServiceImpl.userApprovedPosts(id);
		if (userApprovedPosts!=null) {
			return new ResponseEntity<>(userApprovedPosts, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	@GetMapping("/rejected/posts")
	public ResponseEntity<?> userRejectedPost(@RequestParam Long id) {
		UserResponse userApprovedPosts = userServiceImpl.userRejectedPosts(id);
		if (userApprovedPosts!=null) {
			return new ResponseEntity<>(userApprovedPosts, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
