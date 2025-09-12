package org.example.babplus.product.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.product.factory.ProductFactory;
import org.example.babplus.product.projection.ProductInfo;
import org.example.babplus.product.repository.ProductRepository;
import org.example.babplus.product.vo.RegisterVO;
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

    public void register(RegisterVO requestVO){
        var product = ProductFactory.create(requestVO);
        productRepository.save(product);
    }

}
