package org.example.babplus.product.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.product.infrastructure.persistence.projection.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
@Builder
public class GetProductsResponse {
    @Schema(description = "상품아이디")
    private final Long id;

    @Schema(description = "상품명")
    private final String name;

    @Schema(description = "식권 갯수")
    private final int ticketAmount;

    @Schema(description = "가격")
    private final BigDecimal price;

    public static List<GetProductsResponse> of(List<ProductInfo> productInfos) {
        return productInfos.stream()
                .map(GetProductsResponse::of)
                .toList();
    }

    public static GetProductsResponse of(ProductInfo productInfo) {
        return GetProductsResponse.builder()
                .id(productInfo.getId())
                .name(productInfo.getName())
                .ticketAmount(productInfo.getTicketAmount())
                .price(productInfo.getPrice())
                .build();
    }
}
