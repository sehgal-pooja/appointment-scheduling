package com.pooja.demo.repoistory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pooja.demo.model.Patients;

public interface PatientRepo extends MongoRepository<Patients, Integer> {

	//Iterable<Patients> findByNameContaining(String pname);

	
}
