package com.company.demo.service.impl;

import com.company.demo.entity.Address;
import com.company.demo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("secondImpl")
public class AddressServiceSecondImpl implements AddressService {

    private List<Address> addresses = new ArrayList<>();

    @Override
    public Address get(long id) {
        return addresses.stream().filter(address -> address.getId() == id).findFirst().get();
    }

    @Override
    public void save(Address address) {
        addresses.add(address);
    }

    @Override
    public Address update(Address address) {
        Address myAddress = addresses.stream().filter(address1 -> address.getId() == address1.getId()).findFirst().get();
        myAddress.setAddress(address.getAddress());
        myAddress.setCitizen("Bob Stone");
        return myAddress;
    }

    @Override
    public void delete(long id) {
        addresses.remove(addresses.stream().filter(address -> address.getId() == id).findFirst().get());
    }

    @Override
    public List<Address> getAll() {
        return addresses;
    }

    @Override
    public List<Address> findAddressStartingWithLetter(char letter) {
        return addresses.stream()
                .filter(address -> address.getAddress().startsWith(String.valueOf(letter))).collect(Collectors.toList());
    }
}
