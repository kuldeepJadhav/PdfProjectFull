package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.MachineCategory;

public interface MachineCategoryRepository extends MongoRepository<MachineCategory, ObjectId> {
	
	public Company findByName(String name);
		

}
