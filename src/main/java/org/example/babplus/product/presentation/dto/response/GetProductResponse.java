package org.example.babplus.product.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.product.infrastructure.persistence.projection.ProductInfo;

import java.math.BigDecimal;

@Getter
@ToString
@Builder
public class GetProductResponse {
    @Schema(description = "상품아이디")
    private final Long id;

    @Schema(description = "상품명")
    private final String name;

    @Schema(description = "식권 수량")
    private final int ticketAmount;

    @Schema(description = "가격")
    private final BigDecimal price;

    public static GetProductResponse of(ProductInfo productInfo) {
        return GetProductResponse.builder()
                .id(productInfo.getId())
                .name(productInfo.getName())
                .ticketAmount(productInfo.getTicketAmount())
                .price(productInfo.getPrice())
                .build();
    }
}
