package org.example.babplus.ticketWallet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.payment.entity.Payment;
import org.example.babplus.user.entity.User;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="ticket_wallet")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TicketWallet extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "used_amount")
    private int usedAmount;

    public String getUserId(){
        return this.user.getId();
    }

    public Long getPaymentId(){
        return this.payment.getId();
    }
}
