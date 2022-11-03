package com.testyantra.tutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testyantra.tutorial.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByTutorialId(Long postId);

	@Transactional
	void deleteByTutorialId(long tutorialId);
}
