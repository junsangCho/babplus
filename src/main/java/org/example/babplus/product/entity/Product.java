package org.example.babplus.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.babplus.common.entity.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;

@Entity
@Table(name="product")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ticket_amount", nullable = false)
    private int ticketAmount;

    @Column(name = "price", precision = 15, nullable = false)
    private BigDecimal price;

}
