package com.vmware.awsdemo.nosql.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class PersonModelListener extends AbstractMongoEventListener<Person> {
   private MongoOperations mongoOperations;

   public long generateSequence(String seqName) {
      DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
            new Update().inc("seq", 1), options().returnNew(true).upsert(true),
            DatabaseSequence.class);
      return !Objects.isNull(counter) ? counter.getSeq() : 1;
   }

   @Override public void onBeforeConvert(BeforeConvertEvent<Person> event) {
      if (event.getSource().getId() < 1) {
         event.getSource().setId(generateSequence(Person.SEQUENCE_NAME));
      }
   }
}
