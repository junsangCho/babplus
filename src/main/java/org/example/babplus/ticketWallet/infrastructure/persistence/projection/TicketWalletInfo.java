package org.example.babplus.ticketWallet.infrastructure.persistence.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.ticketWallet.domain.TicketWallet;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class TicketWalletInfo {
    private Long id;
    private String userId;
    private Long paymentId;
    private int totalAmount;
    private int usedAmount;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public TicketWalletInfo(TicketWallet ticketWallet){
        this.id = ticketWallet.getId();
        this.userId = ticketWallet.getUser() == null ? null : ticketWallet.getUserId();
        this.paymentId = ticketWallet.getPayment() == null ? null : ticketWallet.getPaymentId();
        this.totalAmount = ticketWallet.getTotalAmount();
        this.usedAmount = ticketWallet.getUsedAmount();
        this.createdDate = ticketWallet.getCreatedDate();
        this.updatedDate = ticketWallet.getUpdatedDate();
    }
}