package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.Company;

public interface CompanyRepository extends MongoRepository<Company, ObjectId> {
	
	public Company findByName(String name);
		

}
