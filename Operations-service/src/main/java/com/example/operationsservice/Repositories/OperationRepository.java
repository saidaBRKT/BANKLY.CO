package com.example.operationsservice.Repositories;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Entities.Operation;
import com.example.operationsservice.Entities.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    Operation findByReference(String reference);

    // List<Operation> findAllByOperation_type(String operationType);
}
