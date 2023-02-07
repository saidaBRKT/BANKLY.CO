package com.example.operationsservice.Controllers;

import com.example.operationsservice.Dto.OperationDto;
import com.example.operationsservice.Dto.ResponseDto;
import com.example.operationsservice.Services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/all")
    public String pehk(){
        System.out.println("fghjk");
        return "test";
    }

    @PostMapping("/diposit")
    public ResponseDto depositMoney(@RequestBody OperationDto operationDto){
        return null;
    }

    @PostMapping("/withdraw")
    public ResponseDto withdrawMoney(@RequestBody OperationDto operationDto){
        return null;
    }

}
