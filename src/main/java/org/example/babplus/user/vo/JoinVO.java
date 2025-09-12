package org.example.babplus.user.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.auth.dto.JoinRequest;


@Builder
@Getter
public class JoinVO {

    private final String id;
    private final String password;
    private final String name;
    private final String role;
    private final boolean enable;


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
