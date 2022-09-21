package com.tchokouaha.spring.training.demospringboot.vote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Vote extends BaseEntity {
    private String name;
    private int age;
    private VoteType voteType;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}
