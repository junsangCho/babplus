package org.example.babplus.user.factory;

import org.example.babplus.user.entity.User;
import org.example.babplus.user.vo.JoinVO;

public class UserFactory {

    public static User create(JoinVO request, String encodedPassword) {
        return User.builder()
                .id(request.getId())
                .password(encodedPassword)
                .name(request.getName())
                .role(request.getRole())
                .enable(request.isEnable())
                .build();
    }
}
