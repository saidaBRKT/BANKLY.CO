package com.example.walletservice.Repositories;

import com.example.walletservice.Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
   Wallet findByReference(String ref);
}
