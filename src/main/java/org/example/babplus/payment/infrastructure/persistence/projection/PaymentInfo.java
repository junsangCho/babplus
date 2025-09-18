package org.example.babplus.payment.infrastructure.persistence.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.payment.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class PaymentInfo {
    private Long id;
    private String customerKey;
    private String orderId;
    private BigDecimal amount;
    private String paymentType;
    private String status;
    private LocalDateTime approvedDate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public PaymentInfo(Payment payment){
        this.id = payment.getId();
        this.customerKey = payment.getCustomerKey();
        this.orderId = payment.getOrderId();
        this.amount = payment.getAmount();
        this.paymentType = payment.getPaymentType();
        this.status = payment.getStatus();
        this.approvedDate = payment.getApprovedDate();
        this.createdDate = payment.getCreatedDate();
        this.updatedDate = payment.getUpdatedDate();
    }
}