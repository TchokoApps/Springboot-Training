package com.tchokouaha.spring.training.demospringboot.ticket;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private LocalDate eventDate;
    private Integer age;
    private double price;
}
