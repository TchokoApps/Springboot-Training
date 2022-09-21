package com.tchokouaha.spring.training.demospringboot.vote.service;

import com.tchokouaha.spring.training.demospringboot.exception.ResourceNotFoundException;
import com.tchokouaha.spring.training.demospringboot.vote.model.Person;
import com.tchokouaha.spring.training.demospringboot.vote.repository.AddressRepository;
import com.tchokouaha.spring.training.demospringboot.vote.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;
    AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) throws ResourceNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Person with %d not found", id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public Person updatePerson(Long id, Person person) throws ResourceNotFoundException {
        Person personFound = getPersonById(id);

        if(person == null) {
            throw new NullPointerException("Firstname is null");
        }

        if(person.getFirstName().length() < 2) {
            throw new RuntimeException("Firstname length to short...");
        }
        personFound.setFirstName(person.getFirstName());
        personFound.setLastName(person.getLastName());
        return personRepository.save(personFound);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public void deleteAllPersons() {
        personRepository.deleteAll();
    }

    public List<Person> findPersonsByAddressesId(Long addressId) throws ResourceNotFoundException {
        if (!addressRepository.existsById(addressId)) {
            throw new ResourceNotFoundException(String.format("Address with Id: %s not found", addressId));
        }
        return personRepository.findPersonsByAddressesId(addressId);
    }

}
