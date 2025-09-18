package org.example.babplus.auth.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.babplus.auth.presentation.dto.request.LoginRequest;
import org.example.babplus.auth.presentation.dto.response.LoginResponse;
import org.example.babplus.auth.application.service.AuthService;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.jwt.infrastructure.JwtTokenProvider;
import org.example.babplus.ticketWallet.application.service.TicketWalletService;
import org.example.babplus.user.application.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final TicketWalletService ticketWalletService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public CommonResponse<?> login(@RequestBody LoginRequest request){
        var userDetails = authService.authenticateUser(request);
        String token = jwtTokenProvider.generateToken(userDetails);

        var userInfo = userService.getUser(request.getId());
        int ticketAmount = ticketWalletService.getTicketAmount(request.getId());

        return CommonResponse.success(new LoginResponse(userInfo, token, ticketAmount));
    }
}
