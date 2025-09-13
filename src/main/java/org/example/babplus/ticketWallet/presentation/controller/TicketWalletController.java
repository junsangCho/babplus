package org.example.babplus.ticketWallet.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.ticketWallet.presentation.dto.response.GetTicketWalletResponse;
import org.example.babplus.ticketWallet.presentation.dto.response.GetTicketWalletsResponse;
import org.example.babplus.ticketWallet.application.service.TicketWalletService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket-wallet")
public class TicketWalletController {

    private final TicketWalletService ticketWalletService;

    @GetMapping()
    @Operation(summary = "식권상품 리스트 조회", description = "식권상품 리스트 조회")
    public CommonResponse<?> getTicketWallets(@Parameter(hidden = true) @AuthenticationPrincipal UserDetails userDetails){

        var ticketWallets = ticketWalletService.getTicketWallets(userDetails.getUsername());
        var response = GetTicketWalletsResponse.of(ticketWallets);

        return CommonResponse.success(response);
    }

    @GetMapping("/{ticket-wallet-id}")
    @Operation(summary = "식권상품 단일조회", description = "식권상품 단일조회")
    public CommonResponse<?> getProduct(@PathVariable("ticket-wallet-id") Long ticketWalletId) {
        var ticketWalletInfo = ticketWalletService.getTicketWallet(ticketWalletId);
        var response = GetTicketWalletResponse.of(ticketWalletInfo);

        return CommonResponse.success(response);
    }

}
