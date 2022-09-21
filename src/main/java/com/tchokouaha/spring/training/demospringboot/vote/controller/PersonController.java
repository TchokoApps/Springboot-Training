package com.tchokouaha.spring.training.demospringboot.vote.controller;

import com.tchokouaha.spring.training.demospringboot.exception.ResourceNotFoundException;
import com.tchokouaha.spring.training.demospringboot.vote.model.Person;
import com.tchokouaha.spring.training.demospringboot.vote.service.AddressService;
import com.tchokouaha.spring.training.demospringboot.vote.service.PersonService;
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
public class PersonController {
    PersonService personService;
    AddressService addressService;

    @Autowired
    public PersonController(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.of(Optional.of(persons));
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person personCreated = personService.createPerson(person);
        return  ResponseEntity.of(Optional.of(personCreated));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) throws ResourceNotFoundException {
        Person person = personService.getPersonById(id);
        return  ResponseEntity.of(Optional.of(person));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long id, @RequestBody Person person) throws ResourceNotFoundException {
        Person personUpdated = personService.updatePerson(id, person);
        return  ResponseEntity.of(Optional.of(personUpdated));
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        personService.deleteAllPersons();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/addresses/{addressId}/persons")
    public ResponseEntity<List<Person>> findAllPersonsByAddressesId(@PathVariable Long addressId) throws ResourceNotFoundException {
        List<Person> persons = personService.findPersonsByAddressesId(addressId);
        return ResponseEntity.of(Optional.of(persons));
    }

}
