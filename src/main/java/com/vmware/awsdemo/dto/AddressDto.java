package com.vmware.awsdemo.dto;

import java.io.Serializable;
import java.util.UUID;

import com.vmware.awsdemo.rds.model.Address;
import lombok.Data;

import org.springframework.data.annotation.ReadOnlyProperty;

@Data public class AddressDto implements Serializable {
   @ReadOnlyProperty
   private final UUID id;
   private final String line1;
   private final String line2;
   private final String city;
   private final String country;

   public Address toAddress() {
      var address = new Address();
      address.setLine1(getLine1());
      address.setLine2(getLine2());
      address.setCity(getCity());
      address.setCountry(getCountry());
      return address;
   }
}
