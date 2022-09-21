package com.tchokouaha.spring.training.demospringboot.vote.repository;


import com.tchokouaha.spring.training.demospringboot.vote.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    List<Vote> findAll();
}
