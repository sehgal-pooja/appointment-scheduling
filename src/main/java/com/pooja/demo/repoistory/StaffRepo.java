package com.pooja.demo.repoistory;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.pooja.demo.model.Staff;

public interface StaffRepo extends MongoRepository<Staff, Integer>{
	
	
	
}
