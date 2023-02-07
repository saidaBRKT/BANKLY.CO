package com.example.operationsservice.Dto;

import com.example.operationsservice.Entities.Operation;
import org.modelmapper.ModelMapper;

public class TransferEntityToDto {
    public static OperationDto operationToOperationDto(Operation operation) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(operation, OperationDto.class);
    }
}
