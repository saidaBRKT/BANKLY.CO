package com.example.walletservice.Services;

import com.example.walletservice.Dto.ResponseDto;
import com.example.walletservice.Dto.WalletDto;

import java.util.List;

public interface WalletService {
ResponseDto addWallet(WalletDto walletDto);
List<WalletDto> getAllWallet();
WalletDto updateBalance(WalletDto walletDto,String opp,Double sold);
}
