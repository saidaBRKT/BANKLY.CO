package com.example.operationsservice.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseTemplateDto {
    private OperationDto operationDto;
    private WalletDto walletDto;
}
