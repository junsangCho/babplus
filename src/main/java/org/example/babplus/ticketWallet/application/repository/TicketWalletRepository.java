package org.example.babplus.ticketWallet.application.repository;

import org.example.babplus.ticketWallet.domain.TicketWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketWalletRepository extends JpaRepository<TicketWallet, Long>, TicketWalletRepositoryCustom {
}