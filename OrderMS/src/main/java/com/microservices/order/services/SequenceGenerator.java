package com.microservices.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.microservices.order.entity.Sequence;

@Service
public class SequenceGenerator {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	
	public long generateNextOrderId() {
		Query query = new Query(Criteria.where("_id").is("sequence"));
		Update update = new Update().inc("sequence", 1);
		FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
		
		Sequence counter = mongoOperations.findAndModify(
				query,
				update,
				options,
				Sequence.class);
		return counter.getSequence();
	}

}
