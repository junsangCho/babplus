package org.example.babplus.product.repository;

import org.example.babplus.product.projection.ProductInfo;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductInfo> getProducts();
}
