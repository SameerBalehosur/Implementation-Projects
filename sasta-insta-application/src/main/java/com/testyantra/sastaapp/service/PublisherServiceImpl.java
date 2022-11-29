package com.testyantra.sastaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.sastaapp.entity.Posts;
import com.testyantra.sastaapp.entity.Publisher;
import com.testyantra.sastaapp.repository.PostsRepo;
import com.testyantra.sastaapp.repository.PublisherRepo;
import com.testyantra.sastaapp.repository.UserRepo;
import com.testyantra.sastaapp.response.PublisherResponse;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@Service
public class PublisherServiceImpl {
	@Autowired
	PublisherRepo publisherRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostsRepo postsRepo;
	
	public PublisherResponse publisherRegistration(Publisher publisher) {
		if (publisher != null) {
			publisherRepo.save(publisher);
			return PublisherResponse.builder().message("Publisher Registration Success").build();
		} else {
			return PublisherResponse.builder().message("Publisher Registration Failed").build();
		}
	}
	
	public PublisherResponse publisherLogin(Publisher publisher) {
		if (publisher.getPublisherId() !=0 && publisher.getPassword() != null) {
			publisherRepo.findById(publisher.getPublisherId()).orElseThrow();
			return PublisherResponse.builder().message("Publisher Login Success").build();
		} else {
			return PublisherResponse.builder().message("Publisher Login Failed").build();
		}
	}
	
	public PublisherResponse publisherProfile(Long publisherId) {
		if (publisherId != 0) {
			Publisher publisherProfile = publisherRepo.findById(publisherId).orElseThrow();
			if (publisherProfile != null) {
				return PublisherResponse.builder().publisherProfile(publisherProfile).build();
			} else {
				return PublisherResponse.builder().message("User Details Not Found").build();
			}
		} else {
			return PublisherResponse.builder().message("Check Your Publisher ID").build();
		}
	}
	
	public PublisherResponse approveUserPost(Posts posts) {
		
		Posts posts2 = postsRepo.findById(posts.getPostId()).filter(x->x.getStatus().equalsIgnoreCase("pending")).map(y->{
			y.setStatus(posts.getStatus());
			return y;
		}).orElseThrow();
		Posts save = postsRepo.save(posts2);
			if(save!=null) {
			return PublisherResponse.builder().message("User Post Approved").build();
		}return PublisherResponse.builder().message("User Post Not Approved Because of Wrong Content").build();
	}
	

}
