package org.example.babplus.payment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.example.babplus.user.domain.User;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="payment")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Comment("비정규화된 컬럼: User.customerKey 복제 저장 (이력 조회 및 웹훅 대응)")
    @Column(name = "customer_key", nullable = false)
    private String customerKey;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "amount", precision = 15, nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "approved_date", nullable = false)
    private LocalDateTime approvedDate;
}
