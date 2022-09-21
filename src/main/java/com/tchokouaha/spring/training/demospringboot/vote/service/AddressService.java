package com.tchokouaha.spring.training.demospringboot.vote.service;

import com.tchokouaha.spring.training.demospringboot.exception.ResourceNotFoundException;
import com.tchokouaha.spring.training.demospringboot.vote.model.Address;
import com.tchokouaha.spring.training.demospringboot.vote.repository.AddressRepository;
import com.tchokouaha.spring.training.demospringboot.vote.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;
    PersonRepository personRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    List<Address> getAddressesByPersonsId(Long id) throws ResourceNotFoundException {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format("Person with Id: %s not found", id));
        }
        return addressRepository.findAddressesByPersonsId(id);
    }

    public Address getAddressById(Long id) throws ResourceNotFoundException {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Address with Id: %s not found", id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) throws ResourceNotFoundException {

        Address addressFound = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Address with Id: %s not found", id)));
        addressFound.setCity(address.getCity());
        addressFound.setState(address.getState());
        addressFound.setStreet(address.getStreet());
        addressFound.setZipCode(address.getZipCode());

        return addressFound;
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }

    public List<Address> findAddressesByPersonsId(Long personId) throws ResourceNotFoundException {
        if (!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException(String.format("Person with Id: %s not found", personId));
        }
        return addressRepository.findAddressesByPersonsId(personId);
    }
}
