package org.example.babplus.user.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.babplus.auth.presentation.dto.request.JoinRequest;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.user.application.service.UserService;
import org.example.babplus.user.application.dto.command.JoinCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public CommonResponse<?> joinUser(@Valid @RequestBody JoinRequest request) {
        var paramVO = JoinCommand.of(request);

        userService.joinUser(paramVO);

        return CommonResponse.success();
    }
}
