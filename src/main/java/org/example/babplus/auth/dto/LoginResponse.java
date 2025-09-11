package org.example.babplus.auth.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.babplus.user.projection.UserInfo;

@Getter
@ToString
public class LoginResponse {
    private final String loginId;
    private final String customerKey;
    private final int ticketAmount;
    private final String token;


    public LoginResponse(UserInfo userInfo, String token, int ticketAmount) {
        this.loginId = userInfo.getId();
        this.customerKey = userInfo.getCustomerKey();
        this.ticketAmount = ticketAmount;
        this.token = token;
    }
}
