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
import com.testyantra.sastaapp.entity.Publisher;
import com.testyantra.sastaapp.entity.User;
import com.testyantra.sastaapp.response.PublisherResponse;
import com.testyantra.sastaapp.service.PublisherServiceImpl;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@RestController
@RequestMapping("/apis/sasta/publisher")
public class PublisherController {
	@Autowired
	PublisherServiceImpl publisherServiceImpl;

	/** Publisher Registration */
	@PostMapping("/registration")
	public ResponseEntity<?> publisherRegistration(@RequestBody Publisher publisher) {
		PublisherResponse userRegistration = publisherServiceImpl.publisherRegistration(publisher);
		if (userRegistration != null) {
			return new ResponseEntity<>(userRegistration, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/** Publisher Login */
	@PostMapping("/login")
	public ResponseEntity<?> publisherLogin(@RequestBody Publisher publisher) {
		PublisherResponse publisherRegistration = publisherServiceImpl.publisherLogin(publisher);
		if (publisherRegistration != null) {
			return new ResponseEntity<>(publisherRegistration, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/** Getting Publisher Profile Details */
	@GetMapping("/settings/profile")
	public ResponseEntity<?> publisherProfile(@RequestParam Long publisherId) {
		PublisherResponse publisherProfile = publisherServiceImpl.publisherProfile(publisherId);
		if (publisherProfile != null) {
			return new ResponseEntity<>(publisherProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/** Approve Posts which is posted by user */
	@PostMapping("/approve/user/posts")
	public ResponseEntity<?> approveUserPost(@RequestBody Posts posts) {
		PublisherResponse approveUserPost = publisherServiceImpl.approveUserPost(posts);
		if (approveUserPost != null) {
			return new ResponseEntity<>(approveUserPost, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
