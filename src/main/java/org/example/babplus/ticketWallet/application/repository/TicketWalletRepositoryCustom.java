package org.example.babplus.ticketWallet.application.repository;

import org.example.babplus.ticketWallet.infrastructure.persistence.projection.TicketWalletInfo;

import java.util.List;

public interface TicketWalletRepositoryCustom {
    int getTicketAmount(String userId);

    List<TicketWalletInfo> getTicketWallets(String userId);
}
