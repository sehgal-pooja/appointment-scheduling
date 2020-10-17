package com.pooja.demo.repoistory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pooja.demo.model.Admin;

public interface AdminRepo extends MongoRepository<Admin, Integer> {
	
	

}
