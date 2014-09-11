package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.Parts;

public interface PartsRepository extends MongoRepository<Parts, ObjectId> {
	
	public Company findByName(String name);
		

}
