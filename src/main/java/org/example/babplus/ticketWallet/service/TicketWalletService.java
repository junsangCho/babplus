package org.example.babplus.ticketWallet.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.ticketWallet.repository.TicketWalletRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketWalletService {

    private final TicketWalletRepository ticketWalletRepository;

    public int getTicketAmount(String userId){
        return ticketWalletRepository.getTicketAmount(userId);
    }
}
