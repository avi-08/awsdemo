package com.windstorm.awsdemo.rds.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Address {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column(nullable = false)
   private String line1;

   @Column
   private String line2;

   @Column(nullable = false)
   private String city;

   @Column(nullable = false)
   private String country;

   @OneToOne(targetEntity = Person.class, orphanRemoval = true, cascade = { CascadeType.PERSIST,
         CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE, })
   @JoinColumn(name = "address_fk", referencedColumnName = "id")
   @ToString.Exclude
   private Person person;
}
