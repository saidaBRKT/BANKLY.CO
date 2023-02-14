package com.example.walletservice.Services;

import com.example.walletservice.Dto.ResponseDto;
import com.example.walletservice.Dto.ResponseTemplateDto;
import com.example.walletservice.Dto.WalletDto;

import java.util.List;

public interface WalletService {
ResponseDto addWallet(WalletDto walletDto);
List<WalletDto> getAllWallet();
WalletDto updateBalance(WalletDto walletDto,String opp,Double sold);
ResponseTemplateDto getWalletWithUser(Long walletId);
WalletDto getOneWallet(Long walletId);
WalletDto updateBalance(WalletDto walletDto);
}
