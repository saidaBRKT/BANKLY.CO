package com.example.operationsservice.Services;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Dto.ResponseDto;
import com.example.operationsservice.Dto.ResponseTemplateDto;

import java.util.List;

public interface OperationService {
    ResponseDto depositMoney(OperationDto operationDto,Long walletId);
    ResponseDto withdrawMoney(OperationDto operationDto,Long walletId);

    OperationDto addOperation(OperationDto operationDto);

    List<OperationDto> getAllOperations();
}
