package com.example.operationsservice.Controllers;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Dto.ResponseDto;
import com.example.operationsservice.Services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/all-operations")
    public List<OperationDto> AllOperations(){
        return operationService.getAllOperations();
    }


    @PostMapping("/add-operation")
    public OperationDto addOperation(@RequestBody OperationDto operationDto){
        return operationService.addOperation(operationDto);
    }

    @PostMapping("/deposit/{walletId}")
    public ResponseDto depositMoney(@RequestBody OperationDto operationDto,@PathVariable Long walletId){
        return operationService.depositMoney(operationDto,walletId);
    }

    @PostMapping("/withdraw/{walletId}")
    public ResponseDto withdrawMoney(@RequestBody OperationDto operationDto,@PathVariable("walletId") Long walletId){
        return operationService.withdrawMoney(operationDto,walletId);
    }

}
