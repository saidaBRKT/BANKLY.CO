package com.example.walletservice.Services.imp;

import com.example.walletservice.Dto.*;
import com.example.walletservice.Entities.Wallet;
import com.example.walletservice.Feign.UserFeign;
import com.example.walletservice.Repositories.WalletRepository;
import com.example.walletservice.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImp implements WalletService {
    @Autowired
    WalletRepository walletRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeign userFeign;
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

    @Override
    public ResponseTemplateDto getWalletWithUser(Long walletId) {
        ResponseTemplateDto responseTemplateDto=new ResponseTemplateDto();
        Wallet wallet=walletRepository.findById(walletId).get();

        UserDto userDto=userFeign.getOneUser(wallet.getCin_user());
//             restTemplate.getForObject("http://localhost:9091/api/v1/users/cin/"+wallet.getCin_user(),UserDto.class);

        responseTemplateDto.setUserDto(userDto);
        responseTemplateDto.setWalletDto(TransferEntityToDto.walletToWalletDto(wallet));
        return responseTemplateDto;
    }

    @Override
    public WalletDto getOneWallet(Long walletId) {
        return TransferEntityToDto.walletToWalletDto(walletRepository.findById(walletId).get());
    }

    @Override
    public WalletDto updateBalance(WalletDto walletDto) {
        Wallet w=TransferDtoToEntity.walletDtoToWallet(walletDto);
        Wallet wallet=walletRepository.findByReference(w.getReference());
        System.out.println("1:"+w);
        System.out.println("2:"+wallet);
        if(wallet!=null){
            wallet=w;
            Wallet wallet1=walletRepository.save(wallet);
            System.out.println("3:"+wallet);
            System.out.println("4:"+wallet1);
            return TransferEntityToDto.walletToWalletDto(wallet1);
        }else{
            return  null;
        }

    }

}


