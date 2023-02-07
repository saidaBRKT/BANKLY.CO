package com.example.operationsservice.Services.Imp;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Dto.ResponseDto;
import com.example.operationsservice.Dto.TransferDtoToEntity;
import com.example.operationsservice.Entities.Operation;
import com.example.operationsservice.Services.OperationService;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImp implements OperationService {

    @Override
    public ResponseDto depositMoney(OperationDto operationDto) {
        Operation operation= TransferDtoToEntity.operationDtoToOperation(operationDto);
        if(operation==null || operation==new Operation()){
            return new ResponseDto("erreur","L'objet ne doit pas etre null ou vide");
        }else{
            // Ajouter le code
            return null;
        }
    }

    @Override
    public ResponseDto withdrawMoney(OperationDto operationDto) {
        Operation operation= TransferDtoToEntity.operationDtoToOperation(operationDto);
        if(operation==null || operation==new Operation()){
            return new ResponseDto("erreur","L'objet ne doit pas etre null ou vide");
        }else{
            // Ajouter le code
            return null;
        }
    }
}
