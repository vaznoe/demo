package com.company.demo.repository;

import com.company.demo.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findByCitizen(String citizen);
}
