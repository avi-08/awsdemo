package com.windstorm.awsdemo.rds.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity @Getter @Setter @ToString @RequiredArgsConstructor public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column(nullable = false)
   private String name;

   @OneToOne
   @JoinColumn(name = "address_fk")
   @ToString.Exclude
   private Address address;

   @Override public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Person person = (Person) o;
      return id != null && Objects.equals(id, person.id);
   }

   @Override public int hashCode() {
      return getClass().hashCode();
   }
}
