package com.testyantra.sastaapp.repository;

import java.util.List;
/**
 * @author Sameer Balehosur
 *
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testyantra.sastaapp.entity.Posts;
@Repository
public interface PostsRepo extends JpaRepository<Posts,Long>{
	public List<Posts> findByUserUserId(Long userId);
	public List<Posts> findByPublisherPublisherId(Long publisherId);

}
