package org.example.babplus.user.application.factory;

import org.example.babplus.user.domain.User;
import org.example.babplus.user.application.dto.command.JoinCommand;

public class UserFactory {

    public static User create(JoinCommand request, String encodedPassword) {
        return User.builder()
                .id(request.getId())
                .password(encodedPassword)
                .name(request.getName())
                .role(request.getRole())
                .enable(request.isEnable())
                .build();
    }
}
