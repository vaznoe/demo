package com.company.demo.service.impl;

import com.company.demo.entity.Address;
import com.company.demo.repository.AddressRepository;
import com.company.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address get(long id) {
      return addressRepository.findOne(id);
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
         addressRepository.delete(address.getId());
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
    public Address findAddressByCitizen(String citizen) {
        addressRepository.findByCitizen(citizen);
        return null;
    }
}
