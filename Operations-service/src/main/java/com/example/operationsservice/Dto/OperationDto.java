package com.example.operationsservice.Dto;

import com.example.operationsservice.Entities.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto implements Serializable {
    private String reference;
    private LocalDate date;
    private Double amount;
    private OperationType operation_type;

//
//    public OperationDto(String reference, LocalDate date, Double amount, OperationType operation_type) {
//        this.reference=reference;
//        this.date=date;
//        this.amount=amount;
//        this.operation_type=operation_type;
//    }
}
