package org.example.babplus.product.application.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.product.application.dto.command.RegisterCommand;
import org.example.babplus.product.application.factory.ProductFactory;
import org.example.babplus.product.application.repository.ProductRepository;
import org.example.babplus.product.infrastructure.persistence.projection.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductInfo> getProducts(){
        return productRepository.getProducts();
    }

    public ProductInfo getProduct(Long productId){
        return productRepository.findById(productId)
                .map(ProductInfo::new).orElseThrow();
    }

    public void register(RegisterCommand requestVO){
        var product = ProductFactory.create(requestVO);
        productRepository.save(product);
    }

}
