package com.example.operationsservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    private Long id;
    @Column(unique = true)
    private String reference;
    private LocalDate date;
    private Double amount;
    private OperationType operation_type;

}
