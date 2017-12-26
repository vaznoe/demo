package com.company.demo.service;

import com.company.demo.entity.Address;

import java.util.List;

public interface AddressService {

    Address get(long id);

    Address save(Address address);

    Address update(Address address);

    void delete(long id);

    List<Address> getAll();

    Address findAddressByZipCode(String citizen);

}
