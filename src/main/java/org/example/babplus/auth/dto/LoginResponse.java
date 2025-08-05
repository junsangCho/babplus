package org.example.babplus.auth.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@ToString
public class LoginResponse {
    private final String loginId;
    private final String token;

    public LoginResponse(UserDetails userDetails, String token) {
        this.loginId = userDetails.getUsername();
        this.token = token;
    }
}
