package com.tchokouaha.spring.training.demospringboot.vote.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
@AllArgsConstructor
public class AddressId implements Serializable {
    private String city;
    private String street;
}
