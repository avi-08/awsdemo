package com.windstorm.awsdemo.rds.repo;

import java.util.UUID;

import com.windstorm.awsdemo.rds.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRdsRepository extends JpaRepository<Address, UUID> {
}