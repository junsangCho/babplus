package org.example.babplus.product.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.product.presentation.dto.request.RegisterProductRequest;

import java.math.BigDecimal;

@Getter
@Builder
public class RegisterCommand {

    private final String name;
    private final int ticketAmount;
    private final BigDecimal price;

    public static RegisterCommand of(RegisterProductRequest request){
        return RegisterCommand.builder()
                .name(request.getName())
                .ticketAmount(request.getTicketAmount())
                .price(request.getPrice())
                .build();
    }
}
