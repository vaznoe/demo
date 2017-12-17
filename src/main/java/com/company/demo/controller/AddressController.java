package com.company.demo.controller;

import com.company.demo.entity.Address;
import com.company.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/add")
    public void save(@RequestBody Address address) {
        addressService.save(address);
    }

    @GetMapping("/{id}")
    public Address get(@PathVariable long id) {
       return addressService.get(id);
    }

    @PutMapping("/put")
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        addressService.delete(id);
    }

    @GetMapping("/all")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/find_address_by_citizen")
    public Address find(String citizen) {
        return addressService.findAddressByCitizen(citizen);
    }
}
