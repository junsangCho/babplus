package org.example.babplus.auth.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.User.Entity.User;
import org.example.babplus.auth.dto.JoinRequest;


@Builder
@Getter
public class JoinVO {

    private final String id;
    private final String password;
    private final String name;
    private final String role;
    private final boolean enable;


    public User toEntity(String encodedPassword){

        return User.builder()
                .id(this.id)
                .password(encodedPassword)
                .name(this.name)
                .role(this.role)
                .enable(this.enable)
                .build();
    }

    public static JoinVO of(JoinRequest request) {
        return JoinVO.builder()
                .id(request.getId())
                .password(request.getPassword())
                .name(request.getName())
                .role("admin")
                .enable(true)
                .build();
    }
}
