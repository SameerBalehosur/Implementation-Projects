package com.testyantra.tutorial.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testyantra.tutorial.exception.ResourceNotFoundException;
import com.testyantra.tutorial.model.Tutorial;
import com.testyantra.tutorial.repository.TutorialRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
@Component
public class TutorialServiceImpl {
	@Autowired
	TutorialRepository tutorialRepository;

	public List<Tutorial> getAllTutorials(String title) {
		try {
			List<Tutorial> tutorials = new ArrayList<>();

			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				throw new ResourceNotFoundException("No Data Found");
			}
			return tutorials;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
