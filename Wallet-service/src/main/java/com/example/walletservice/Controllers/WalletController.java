package com.example.walletservice.Controllers;

import com.example.walletservice.Dto.ResponseDto;
import com.example.walletservice.Dto.WalletDto;
import com.example.walletservice.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wallets")
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

}
