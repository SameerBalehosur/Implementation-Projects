package com.testyantra.sastaapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testyantra.sastaapp.entity.Posts;
import com.testyantra.sastaapp.entity.PostsPojo;
import com.testyantra.sastaapp.entity.User;
import com.testyantra.sastaapp.repository.UserRepo;
import com.testyantra.sastaapp.response.UserResponse;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@Service
public class UserServiceImpl {
	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserResponse userRegistration(User user) {
		if (user != null) {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepo.save(user);
			return UserResponse.builder().message("User Registration Success").build();
		} else {
			return UserResponse.builder().message("User Registration Failed").build();
		}
	}

	public UserResponse userLogin(User user) {
		Optional<User> findById = userRepo.findById(user.getUserId());
		if (!findById.isEmpty() && user.getUserId() != 0 && user.getPassword().equals(findById.get().getPassword())) {
			return UserResponse.builder().message("User Login Success").build();
		}

		return UserResponse.builder().message("User Login Failed").build();
	}

	public UserResponse userProfile(Long userId) {
		if (userId != 0) {
			User userProfile = userRepo.findById(userId).orElseThrow();
			if (userProfile != null) {
				return UserResponse.builder().userProfile(User.builder().email(userProfile.getEmail()).name(userProfile.getName()).password(userProfile.getPassword()).phoneNumber(userProfile.getPhoneNumber()).status(userProfile.getStatus()).userId(userProfile.getUserId()).build()).build();
			} else {
				return UserResponse.builder().message("User Details Not Found").build();
			}
		} else {
			return UserResponse.builder().message("Check Your userID").build();
		}
	}

	public UserResponse getAllPosts(User user) {
		long userId = user.getUserId();

		PostsPojo postsPojo = userRepo.findById(userId)
				.map(userDto -> PostsPojo.builder().name(userDto.getName()).build()).orElseThrow();
		List<PostsPojo> list = new ArrayList<>();
		list.add(postsPojo);
		return UserResponse.builder().postsPojosList(list).build();

	}

	public UserResponse getAllPostsToUsers() {
		Stream<PostsPojo> map = userRepo.findAll().stream()
				.map(posts -> PostsPojo.builder().name(posts.getName()).build());
		List<PostsPojo> collect = map.collect(Collectors.toList());
		return UserResponse.builder().postsPojosList(collect).build();

	}

	public UserResponse userApprovedPosts(Long id) {
		if(id!=0) {
		List<Posts> list = userRepo
				.findById(id).map(y -> y.getListOfPosts().stream()
						.filter(a -> a.getStatus().equalsIgnoreCase("Approved")).collect(Collectors.toList()))
				.orElseThrow();
		return UserResponse.builder().totalNoOfApprovedPosts(list.size()).build();
		}
		return UserResponse.builder().message("Wrong User Id").build();
	}

	public UserResponse userRejectedPosts(Long id) {
		if(id!=0) {
		List<Posts> rejectedPosts = userRepo
				.findById(id).map(y -> y.getListOfPosts().stream()
						.filter(a -> a.getStatus().equalsIgnoreCase("Reject")).collect(Collectors.toList()))
				.orElseThrow();
		int size = rejectedPosts.size();
		return UserResponse.builder().totalNoOfRejectedPosts(size).build();
		}
		return UserResponse.builder().message("Wrong User Id").build();
	}

}
