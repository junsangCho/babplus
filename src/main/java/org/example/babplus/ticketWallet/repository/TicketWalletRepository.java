package org.example.babplus.ticketWallet.repository;

import org.example.babplus.ticketWallet.entity.TicketWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketWalletRepository extends JpaRepository<TicketWallet, Long>, TicketWalletRepositoryCustom {
}