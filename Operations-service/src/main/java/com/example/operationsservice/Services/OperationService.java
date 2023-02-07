package com.example.operationsservice.Services;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Dto.ResponseDto;

public interface OperationService {
    ResponseDto depositMoney(OperationDto operationDto);
    ResponseDto withdrawMoney(OperationDto operationDto);
}
