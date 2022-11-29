package com.testyantra.sastaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.sastaapp.entity.Posts;
import com.testyantra.sastaapp.repository.PostsRepo;
import com.testyantra.sastaapp.response.UserResponse;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@Service
public class PostsServiceImpl {

	@Autowired
	PostsRepo postsRepo;
	
	public UserResponse addUserPost(Posts posts) {
		if(posts!=null) {
			Posts save = postsRepo.save(posts);
			return UserResponse.builder().posts(save).message("User Post Posted Successfully").build();
		}
		return UserResponse.builder().message("Post Posted Failed").build();
		
	}
	
	public UserResponse allPostsByUser(Long userId) {
		try {
		if(userId>0) {
			List<Posts> findByUserId = postsRepo.findByUserUserId(userId);
			if(!findByUserId.isEmpty()) {
				int size = findByUserId.size();
				return UserResponse.builder().listOfPosts(findByUserId).message("Lists Of Posts By User").totalNoOfPosts(size).build();
			}
		}
		}catch (Exception e) {
			System.out.println("exception occure due to"+e);
		}
		return UserResponse.builder().message("Lists Of Posts").build();
		
	}
	
	public UserResponse addPublisherPost(Posts posts) {
		if(posts!=null) {
			Posts save = postsRepo.save(posts);
			return UserResponse.builder().posts(save).message("Publisher Post Posted Successfully").build();
		}
		return UserResponse.builder().message("Publisher Post Posted Failed").build();
		
	}
	
	public UserResponse allPostsByPublisher(Long publisherId) {
		if(publisherId>0) {
			List<Posts> findByUserId = postsRepo.findByPublisherPublisherId(publisherId);
			List<Posts> listOfPosts = findByUserId.stream().collect(Collectors.toList());
			if(!listOfPosts.isEmpty()) {
				int size = listOfPosts.size();
				return UserResponse.builder().listOfPosts(listOfPosts).message("Lists Of Posts By Publisher").totalNoOfPosts(size).build();
			}
		}
		return UserResponse.builder().message("Lists Of Posts").build();
		
	}
	
	
	public UserResponse allPostsByPublisherAndUser() {
			List<Posts> findAll = postsRepo.findAll();
			if(!findAll.isEmpty()) {
				int size = findAll.size();
				return UserResponse.builder().allListOfPosts(findAll).message("Lists Of Posts By Both Publisher and User ").totalNoOfPosts(size).build();
		}
		return UserResponse.builder().message("Lists Of Posts").build();
		
	}
}
