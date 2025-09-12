package org.example.babplus.product.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class RegisterProductRequest {
    @Schema(description = "상품명")
    private String name;

    @Schema(description = "가격")
    private BigDecimal price;

    @Schema(description = "식권 수량")
    private int ticketAmount;
}
