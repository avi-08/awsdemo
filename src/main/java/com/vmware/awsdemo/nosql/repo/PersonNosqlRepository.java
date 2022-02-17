package com.vmware.awsdemo.nosql.repo;

import java.util.List;
import java.util.UUID;

import com.vmware.awsdemo.nosql.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonNosqlRepository extends MongoRepository<Person, UUID> {
   @Query("{name:'?0'}") List<Person> findPersonsByName(String name);

   List<Person> findAllByAddressCity(String city);

   List<Person> findAllByAddressCountryLike(String city);
}
