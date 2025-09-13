package org.example.babplus.product.application.factory;

import org.example.babplus.product.application.dto.command.RegisterCommand;
import org.example.babplus.product.domain.Product;

public class ProductFactory {

    public static Product create(RegisterCommand registerCommand) {
        return Product.builder()
                .name(registerCommand.getName())
                .ticketAmount(registerCommand.getTicketAmount())
                .price(registerCommand.getPrice())
                .build();
    }
}
