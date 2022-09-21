package com.tchokouaha.spring.training.demospringboot.vote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "person_address",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    Set<Address> addresses = new HashSet<>();
}
