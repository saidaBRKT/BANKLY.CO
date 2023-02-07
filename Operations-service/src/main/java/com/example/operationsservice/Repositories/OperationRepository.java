package com.example.operationsservice.Repositories;

import com.example.operationsservice.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {

}
