package org.example.babplus.product.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.product.application.dto.command.RegisterCommand;
import org.example.babplus.product.application.service.ProductService;
import org.example.babplus.product.presentation.dto.request.RegisterProductRequest;
import org.example.babplus.product.presentation.dto.response.GetProductResponse;
import org.example.babplus.product.presentation.dto.response.GetProductsResponse;
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
        var productInfo = productService.getProduct(productId);
        var response = GetProductResponse.of(productInfo);

        return CommonResponse.success(response);
    }

    @PostMapping()
    @Operation(summary = "식권상품 등록", description = "식권상품 등록")
    public CommonResponse<?> registerProduct(@RequestBody RegisterProductRequest request){
        var requestVO = RegisterCommand.of(request);
        productService.register(requestVO);
        return CommonResponse.success();
    }
}
