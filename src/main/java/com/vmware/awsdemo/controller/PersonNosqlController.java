package com.vmware.awsdemo.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.vmware.awsdemo.nosql.model.Person;
import com.vmware.awsdemo.nosql.repo.PersonNosqlRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/nosql/persons") @RequiredArgsConstructor public class PersonNosqlController {
   private final PersonNosqlRepository personRepository;

   @GetMapping public List<Person> getAllPersons(@RequestParam(required = false) String city,
         @RequestParam(required = false) String country) {
      if (null != city) {
         return personRepository.findAllByAddressCity(city);
      }
      if (null != country) {
         return personRepository.findAllByAddressCountryLike(country);
      }
      return personRepository.findAll();
   }

   @GetMapping("/{id}") public Person findOne(@PathVariable UUID id) throws IOException {
      return personRepository.findById(id).orElseThrow(IOException::new);
   }

   @PostMapping @ResponseStatus(HttpStatus.CREATED) public Person create(
         @RequestBody Person person) {
      return personRepository.save(person);
   }

}
