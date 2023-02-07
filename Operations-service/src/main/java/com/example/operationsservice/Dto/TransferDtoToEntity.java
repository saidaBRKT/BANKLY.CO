package com.example.operationsservice.Dto;

import com.example.operationsservice.Entities.Operation;
import org.modelmapper.ModelMapper;

public class TransferDtoToEntity {

    public static Operation operationDtoToOperation(OperationDto operationDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(operationDto,Operation.class);
    }
}
