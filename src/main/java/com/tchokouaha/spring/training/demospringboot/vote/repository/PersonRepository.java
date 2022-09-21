package com.tchokouaha.spring.training.demospringboot.vote.repository;

import com.tchokouaha.spring.training.demospringboot.vote.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    List<Person> findPersonsByAddressesId(Long addressId);
}
