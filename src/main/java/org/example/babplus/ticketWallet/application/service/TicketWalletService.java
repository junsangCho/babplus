package org.example.babplus.ticketWallet.application.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.ticketWallet.infrastructure.persistence.projection.TicketWalletInfo;
import org.example.babplus.ticketWallet.application.repository.TicketWalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketWalletService {

    private final TicketWalletRepository ticketWalletRepository;

    public int getTicketAmount(String userId){
        return ticketWalletRepository.getTicketAmount(userId);
    }

    public List<TicketWalletInfo> getTicketWallets(String userId){
        return ticketWalletRepository.getTicketWallets(userId);
    }

    public TicketWalletInfo getTicketWallet(Long ticketWalletId){
        return ticketWalletRepository.findById(ticketWalletId)
                .map(TicketWalletInfo::new).orElseThrow();
    }
}
