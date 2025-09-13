package org.example.babplus.product.application.repository;

import org.example.babplus.product.infrastructure.persistence.projection.ProductInfo;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductInfo> getProducts();
}
