package com.vmware.awsdemo.dto;

import java.io.Serializable;
import java.util.UUID;

import com.vmware.awsdemo.dto.AddressDto;
import com.vmware.awsdemo.rds.model.Person;
import lombok.Data;

import org.springframework.data.annotation.ReadOnlyProperty;

@Data public class PersonDto implements Serializable {
   @ReadOnlyProperty
   private final UUID id;
   private final String name;
   private final AddressDto address;

   public Person toPerson() {
      var person = new Person();
      person.setName(name);
      return person;
   }
}
