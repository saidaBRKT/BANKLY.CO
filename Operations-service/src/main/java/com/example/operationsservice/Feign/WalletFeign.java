package com.example.operationsservice.Feign;

import com.example.operationsservice.Dto.ResponseTemplateDto;
import com.example.operationsservice.Dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wallet",url = "http://localhost:9093/api/v1/wallets")
public interface WalletFeign {
    @GetMapping("/get-wallet-by-id/{id}")
    public WalletDto getWalletById(@PathVariable("id") Long walletId );

    @PutMapping("/update-balance")
    public WalletDto updateBalance(@RequestBody WalletDto walletDto);
}
