package org.example.babplus.product.factory;

import org.example.babplus.product.entity.Product;
import org.example.babplus.product.vo.RegisterVO;

public class ProductFactory {

    public static Product create(RegisterVO registerVO) {
        return Product.builder()
                .name(registerVO.getName())
                .ticketAmount(registerVO.getTicketAmount())
                .price(registerVO.getPrice())
                .build();
    }
}
