package org.example.babplus.user.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.auth.presentation.dto.request.JoinRequest;


@Builder
@Getter
public class JoinCommand {

    private final String id;
    private final String password;
    private final String name;
    private final String role;
    private final boolean enable;


    public static JoinCommand of(JoinRequest request) {
        return JoinCommand.builder()
                .id(request.getId())
                .password(request.getPassword())
                .name(request.getName())
                .role("admin")
                .enable(true)
                .build();
    }
}
