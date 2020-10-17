package com.pooja.demo.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pooja.demo.model.StaffDatabaseSeq;

@Service
public class StaffSeqGeneratorService {

	private static MongoOperations mongoOperations;
			
			@Autowired
			public StaffSeqGeneratorService(MongoOperations mongoOperations) {
				super();
				this.mongoOperations = mongoOperations;
			}

			public static long generateSequence(String seqName) {
				StaffDatabaseSeq counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
		                new Update().inc("seq",1), options().returnNew(true).upsert(true),
		                StaffDatabaseSeq.class);
		        return !Objects.isNull(counter) ? counter.getSeq() : 1;

			}


		}



