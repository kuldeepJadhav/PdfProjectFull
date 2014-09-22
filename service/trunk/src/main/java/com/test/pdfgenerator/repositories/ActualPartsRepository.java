package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.ActualParts;

public interface ActualPartsRepository extends MongoRepository<ActualParts, ObjectId> {
	public ActualParts findByName(String name);

}
