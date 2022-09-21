package com.tchokouaha.spring.training.demospringboot.vote.controller;

import com.tchokouaha.spring.training.demospringboot.exception.ResourceNotFoundException;
import com.tchokouaha.spring.training.demospringboot.vote.model.Address;
import com.tchokouaha.spring.training.demospringboot.vote.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class AddressController {
    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> allAddresses = addressService.getAllAddresses();
        return ResponseEntity.of(Optional.of(allAddresses));
    }

    @PostMapping("/addresses")
    ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address addressCreated = addressService.createAddress(address);
        return  ResponseEntity.of(Optional.of(addressCreated));
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) throws ResourceNotFoundException {
        Address address = addressService.getAddressById(id);
        return  ResponseEntity.of(Optional.of(address));
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address ) throws ResourceNotFoundException {
        Address addressUpdated = addressService.updateAddress(id, address);
        return  ResponseEntity.of(Optional.of(addressUpdated));
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/addresses")
    public ResponseEntity<HttpStatus> deleteAllAddresses() {
        addressService.deleteAllAddresses();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("persons/{personsId}/addresses")
    public  ResponseEntity<List<Address>>  findAllAddressesByPersonsId(@PathVariable Long personId) throws ResourceNotFoundException {
        List<Address> addresses = addressService.findAddressesByPersonsId(personId);
        return  ResponseEntity.of(Optional.of(addresses));
    }
}
