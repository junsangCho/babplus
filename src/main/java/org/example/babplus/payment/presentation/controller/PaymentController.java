package org.example.babplus.payment.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/orders")
    @Operation(summary = "결제 정보 등록", description = "결제 정보 등록")
    public CommonResponse<?> createOder(){
        return null;
    }
}
