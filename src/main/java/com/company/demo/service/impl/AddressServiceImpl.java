package com.company.demo.service.impl;

import com.company.demo.entity.Address;
import com.company.demo.repository.AddressRepository;
import com.company.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address get(long id) {
      return addressRepository.findOne(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);
    }

    @Override
    public List<Address> getAll() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address findAddressByZipCode(String citizen) {
        addressRepository.findAddressByZipCode(citizen);
        return null;
    }
}
