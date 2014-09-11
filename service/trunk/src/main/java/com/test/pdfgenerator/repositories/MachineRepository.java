package com.test.pdfgenerator.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.pdfgenerator.pojo.Machine;

public interface MachineRepository extends MongoRepository<Machine, ObjectId> {
	
	public Machine findByMachineName(String name);
	

	
}
