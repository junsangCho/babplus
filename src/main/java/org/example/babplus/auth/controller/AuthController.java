package org.example.babplus.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.babplus.auth.dto.JoinRequest;
import org.example.babplus.auth.dto.LoginRequest;
import org.example.babplus.auth.dto.LoginResponse;
import org.example.babplus.auth.service.AuthService;
import org.example.babplus.auth.vo.JoinVO;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.jwt.JwtTokenProvider;
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
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public CommonResponse<?> login(@RequestBody LoginRequest request){
        var userDetails = authService.authenticateUser(request);
        String token = jwtTokenProvider.generateToken(userDetails);

        return CommonResponse.success(new LoginResponse(userDetails, token));
    }

    @PostMapping("/join")
    public CommonResponse<?> joinUser(@Valid @RequestBody JoinRequest request) {
        var paramVO = JoinVO.of(request);

        authService.joinUser(paramVO);

        return CommonResponse.success();
    }
}
