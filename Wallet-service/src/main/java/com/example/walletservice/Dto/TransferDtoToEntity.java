package com.example.walletservice.Dto;

import com.example.walletservice.Entities.Wallet;
import org.modelmapper.ModelMapper;

public class TransferDtoToEntity {

    public static Wallet walletDtoToWallet(WalletDto walletDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(walletDto, Wallet.class);
    }
}
