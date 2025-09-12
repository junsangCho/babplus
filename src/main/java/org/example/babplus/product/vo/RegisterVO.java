package org.example.babplus.product.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.product.dto.request.RegisterProductRequest;

import java.math.BigDecimal;

@Getter
@Builder
public class RegisterVO {

    private final String name;
    private final int ticketAmount;
    private final BigDecimal price;

    public static RegisterVO of(RegisterProductRequest request){
        return RegisterVO.builder()
                .name(request.getName())
                .ticketAmount(request.getTicketAmount())
                .price(request.getPrice())
                .build();
    }
}
