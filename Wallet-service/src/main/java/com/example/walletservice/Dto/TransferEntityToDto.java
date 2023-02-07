package com.example.walletservice.Dto;

import com.example.walletservice.Entities.Wallet;
import org.modelmapper.ModelMapper;

public class TransferEntityToDto {
    public static WalletDto walletToWalletDto(Wallet wallet) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(wallet, WalletDto.class);
    }
}
