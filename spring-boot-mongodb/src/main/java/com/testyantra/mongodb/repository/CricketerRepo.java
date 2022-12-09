package com.testyantra.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testyantra.mongodb.model.Cricketers;

public interface CricketerRepo extends MongoRepository<Cricketers, Integer> {
	
	


}
