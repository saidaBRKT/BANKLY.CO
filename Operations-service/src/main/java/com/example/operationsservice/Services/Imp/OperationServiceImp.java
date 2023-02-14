package com.example.operationsservice.Services.Imp;

import com.example.operationsservice.Dto.*;
import com.example.operationsservice.Entities.Operation;
import com.example.operationsservice.Entities.OperationType;
import com.example.operationsservice.Feign.WalletFeign;
import com.example.operationsservice.Repositories.OperationRepository;
import com.example.operationsservice.Services.OperationService;
import com.example.operationsservice.Util.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImp implements OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private WalletFeign walletFeign;

    @Override
    public ResponseDto depositMoney(OperationDto operationDto,Long walletId) {
        Operation operation= TransferDtoToEntity.operationDtoToOperation(operationDto);
        WalletDto walletDto=walletFeign.getWalletById(walletId);
        Operation opRef=operationRepository.findByReference(operation.getReference());

        if(opRef!=null){
            return new ResponseDto("erreur","L'opperation avec cet referenece exist déja");
        }
        else if(operation.getAmount()<=0){
            return new ResponseDto("erreur","Le montant doit etre superieur a 0");
        }else{
            operation.setReference(GenerateReference.getAlphaNumericString(20));
            operation.setDate(LocalDate.now());
            operation.setOperation_type(OperationType.Diposit);
            Double money= walletDto.getBalance();
            walletDto.setBalance(money+operation.getAmount());
            WalletDto walletDto1=walletFeign.updateBalance(walletDto);
            Operation operation1=operationRepository.save(operation);
            ResponseTemplateDto responseTemplateDto=new ResponseTemplateDto();
            responseTemplateDto.setWalletDto(walletDto1);
            responseTemplateDto.setOperationDto(TransferEntityToDto.operationToOperationDto(operation1));
            return new ResponseDto("success","deposit with success",responseTemplateDto);
        }
    }

    @Override
    public ResponseDto withdrawMoney(OperationDto operationDto,Long walletId) {
        Operation operation= TransferDtoToEntity.operationDtoToOperation(operationDto);
        WalletDto walletDto=walletFeign.getWalletById(walletId);
        Operation opRef=operationRepository.findByReference(operation.getReference());
        if(opRef!=null){
            return new ResponseDto("erreur","L'opperation avec cet referenece exist déja");
        }
        else if(operation.getAmount()<=0){
            return new ResponseDto("erreur","Le montant doit etre superieur a 0");
        } else if (operation.getAmount()>walletDto.getBalance()) {
            return new ResponseDto("erreur","Le montant a retiree est plus grand que votre solde");
        }else{
            operation.setReference(GenerateReference.getAlphaNumericString(20));
            operation.setDate(LocalDate.now());
            operation.setOperation_type(OperationType.Withdraw);
            Double money= walletDto.getBalance();
            walletDto.setBalance(money-operation.getAmount());
            WalletDto walletDto1=walletFeign.updateBalance(walletDto);
            Operation operation1=operationRepository.save(operation);
            ResponseTemplateDto responseTemplateDto=new ResponseTemplateDto();
            responseTemplateDto.setWalletDto(walletDto1);
            responseTemplateDto.setOperationDto(TransferEntityToDto.operationToOperationDto(operation1));
            return new ResponseDto("success","withdraw with success",responseTemplateDto);
        }
    }

    @Override
    public OperationDto addOperation(OperationDto operationDto) {
        Operation operation= TransferDtoToEntity.operationDtoToOperation(operationDto);
        OperationDto operationDto1= TransferEntityToDto.operationToOperationDto(operationRepository.save(operation));
        return operationDto1;
    }

    @Override
    public List<OperationDto> getAllOperations() {
        return operationRepository.findAll().stream().map(op->TransferEntityToDto.operationToOperationDto(op)).collect(Collectors.toList());
    }
}
