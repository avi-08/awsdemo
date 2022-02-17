package com.vmware.awsdemo.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.vmware.awsdemo.dto.PersonDto;
import com.vmware.awsdemo.rds.model.Person;
import com.vmware.awsdemo.rds.repo.AddressRdsRepository;
import com.vmware.awsdemo.rds.repo.PersonRdsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/rds/persons") @RequiredArgsConstructor public class PersonRdsController {
   private final PersonRdsRepository personRepository;
   private final AddressRdsRepository addressRepository;

   @GetMapping public List<Person> getAllPersons() {
      System.out.println("Getting all persons");
      return personRepository.findAll();
   }

   @GetMapping("/{id}") public Person findOne(@PathVariable UUID id) throws IOException {
      return personRepository.findById(id).orElseThrow(IOException::new);
   }

   @PostMapping @ResponseStatus(HttpStatus.CREATED) public Person create(
         @RequestBody PersonDto personDto) {
      var address = addressRepository.save(personDto.getAddress().toAddress());
      var person = personDto.toPerson();
      person.setAddress(address);
      return personRepository.save(person);
   }

}
