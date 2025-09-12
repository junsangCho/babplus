package org.example.babplus.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.product.dto.request.RegisterProductRequest;
import org.example.babplus.product.dto.response.GetProductResponse;
import org.example.babplus.product.dto.response.GetProductsResponse;
import org.example.babplus.product.service.ProductService;
import org.example.babplus.product.vo.RegisterVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    @Operation(summary = "식권상품 리스트 조회", description = "식권상품 리스트 조회")
    public CommonResponse<?> getProducts(){
        var productInfos = productService.getProducts();
        var response = GetProductsResponse.of(productInfos);

        return CommonResponse.success(response);
    }

    @GetMapping("/{product-id}")
    @Operation(summary = "식권상품 단일조회", description = "식권상품 단일조회")
    public CommonResponse<?> getProduct(@PathVariable("product-id") Long productId) {
        var ProductInfo = productService.getProduct(productId);
        var response = GetProductResponse.of(ProductInfo);

        return CommonResponse.success(response);
    }

    @PostMapping()
    @Operation(summary = "식권상품 등록", description = "식권상품 등록")
    public CommonResponse<?> registerProduct(@RequestBody RegisterProductRequest reqeust){
        var requestVO = RegisterVO.of(reqeust);
        productService.register(requestVO);
        return CommonResponse.success();
    }
}
