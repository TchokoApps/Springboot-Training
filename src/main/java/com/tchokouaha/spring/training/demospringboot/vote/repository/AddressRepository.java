package com.tchokouaha.spring.training.demospringboot.vote.repository;

import com.tchokouaha.spring.training.demospringboot.vote.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAll();

    List<Address> findAddressesByPersonsId(Long personId);
}
