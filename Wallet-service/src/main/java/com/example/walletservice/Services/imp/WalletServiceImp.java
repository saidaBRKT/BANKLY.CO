package com.example.walletservice.Services.imp;

import com.example.walletservice.Dto.ResponseDto;
import com.example.walletservice.Dto.TransferDtoToEntity;
import com.example.walletservice.Dto.TransferEntityToDto;
import com.example.walletservice.Dto.WalletDto;
import com.example.walletservice.Entities.Wallet;
import com.example.walletservice.Repositories.WalletRepository;
import com.example.walletservice.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImp implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public ResponseDto addWallet(WalletDto walletDto) {
        Wallet wallet= TransferDtoToEntity.walletDtoToWallet(walletDto);
        Wallet wallet1= walletRepository.save(wallet);
        WalletDto walletDto1= TransferEntityToDto.walletToWalletDto(wallet1);
        return new ResponseDto("success" ,"ajout avec success",walletDto1);
    }

    @Override
    public List<WalletDto> getAllWallet() {
        return walletRepository.findAll().stream().map(wallet->TransferEntityToDto.walletToWalletDto(wallet)).collect(Collectors.toList());
    }

    @Override
    public WalletDto updateBalance(WalletDto walletDto,String opp,Double solde) {
        Wallet wallet=TransferDtoToEntity.walletDtoToWallet(walletDto);
        Wallet wallet1=walletRepository.findByReference(wallet.getReference());
        if(wallet1!=null){
            if(opp.equals("Deposit")){
                Double sold=wallet1.getBalance();
            }
            wallet1.setBalance(wallet.getBalance());
            wallet1.setCin_user(wallet.getCin_user());
            wallet1.setCreated_at(wallet.getCreated_at());
        }

        return null;
    }

}


