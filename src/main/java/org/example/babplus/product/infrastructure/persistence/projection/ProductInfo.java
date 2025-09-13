package org.example.babplus.product.infrastructure.persistence.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.product.domain.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class ProductInfo {
    private Long id;
    private String name;
    private int ticketAmount;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public ProductInfo(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.ticketAmount = product.getTicketAmount();
        this.price = product.getPrice();
        this.createdDate = product.getCreatedDate();
        this.updatedDate = product.getUpdatedDate();
    }
}