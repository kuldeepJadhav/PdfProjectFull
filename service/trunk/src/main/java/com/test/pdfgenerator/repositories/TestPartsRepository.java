package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.TestParts;

public interface TestPartsRepository extends MongoRepository<TestParts, ObjectId> {
	public TestParts findByName(String name);
}
