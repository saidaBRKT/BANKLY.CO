package com.example.walletservice.Controllers;

import com.example.walletservice.Dto.ResponseDto;
import com.example.walletservice.Dto.ResponseTemplateDto;
import com.example.walletservice.Dto.WalletDto;
import com.example.walletservice.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/get-all-wallet")
    public List<WalletDto> getAllWallets(){
        return walletService.getAllWallet();
    }

    @PostMapping("/add-wallet")
    public ResponseDto addWallet(@RequestBody WalletDto walletDto){
        return walletService.addWallet(walletDto);
    }

    @GetMapping("/get-wallet-by-id/{id}")
    public WalletDto getWalletById(@PathVariable("id") Long walletId ){
        return walletService.getOneWallet(walletId);
    }

    @GetMapping("/{id}")
    public ResponseTemplateDto getOneWalletById(@PathVariable("id") Long walletId ){
        return walletService.getWalletWithUser(walletId);
    }

    @PutMapping("/update-balance")
    public WalletDto updateBalance(@RequestBody WalletDto walletDto){
        return walletService.updateBalance(walletDto);
    }

//    @PostMapping("/deposit-money-to-balance")
//    public WalletDto depositMoney(@RequestBody WalletDto walletDto){
//        return walletService.depositMoney(walletDto);
//    }

}
