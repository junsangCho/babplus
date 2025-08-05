package org.example.babplus.auth.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.User.Entity.User;
import org.example.babplus.auth.dto.JoinRequest;


@Builder
@Getter
public class JoinVO {

    private final String loginId;
    private final String password;
    private final String name;
    private final String role;
    private final boolean enable;


    public User toEntity(String encodedPassword){

        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword)
                .name(this.name)
                .role(this.role)
                .enable(this.enable)
                .build();
    }

    public static JoinVO of(JoinRequest request) {
        return JoinVO.builder()
                .loginId(request.getId())
                .password(request.getPassword())
                .name(request.getName())
                .role("admin")
                .enable(true)
                .build();
    }
}
