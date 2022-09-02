package com.windstorm.awsdemo.nosql.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("persons")
@Data
public class Person {
   @Transient
   public static final String SEQUENCE_NAME = "persons_sequence";

   @Id
   private long id;

   private String name;

   private Address address;
}
