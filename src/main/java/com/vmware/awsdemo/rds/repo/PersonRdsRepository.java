package com.vmware.awsdemo.rds.repo;

import java.util.List;
import java.util.UUID;

import com.vmware.awsdemo.rds.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRdsRepository extends JpaRepository<Person, UUID> {
   List<Person> findAllByName(String name);
}