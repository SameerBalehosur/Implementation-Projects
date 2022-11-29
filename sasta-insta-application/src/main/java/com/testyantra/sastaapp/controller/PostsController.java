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

import com.testyantra.sastaapp.entity.Posts;
import com.testyantra.sastaapp.response.UserResponse;
import com.testyantra.sastaapp.service.PostsServiceImpl;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@RestController
@RequestMapping("/apis/sasta/posts")
public class PostsController {
	@Autowired
	PostsServiceImpl postsServiceImpl;
	
	
	/** Adding User Post */
	@PostMapping("/add/posts/user")
	public ResponseEntity<?> userApprovedPost(@RequestBody Posts posts) {
		UserResponse addUserPost = postsServiceImpl.addUserPost(posts);
		if (addUserPost != null) {
			return new ResponseEntity<>(addUserPost, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/** Getting User Post */
	@GetMapping("/get/posts/user")
	public ResponseEntity<?> allPostsByUser(@RequestParam Long userId) {
		try {
		UserResponse addUserPost = postsServiceImpl.allPostsByUser(userId);
		if (addUserPost != null) {
			return new ResponseEntity<>(addUserPost, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** Adding Publisher Post */
	@PostMapping("/add/posts/publisher")
	public ResponseEntity<?> addPublisherPost(@RequestBody Posts posts) {
		UserResponse addPublisherPost = postsServiceImpl.addPublisherPost(posts);
		if (addPublisherPost != null) {
			return new ResponseEntity<>(addPublisherPost, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/** Getting Publisher Post */
	@GetMapping("/get/posts/publisher")
	public ResponseEntity<?> allPostsByPublisher(@RequestParam Long publisherId) {
		UserResponse addUserPost = postsServiceImpl.allPostsByPublisher(publisherId);
		if (addUserPost != null) {
			return new ResponseEntity<>(addUserPost, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/** Getting All Posts */
	@GetMapping("/get/posts/all")
	public ResponseEntity<?> allPostsByPublisherAndUser() {
		UserResponse allPosts = postsServiceImpl.allPostsByPublisherAndUser();
		if (allPosts != null) {
			return new ResponseEntity<>(allPosts, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
