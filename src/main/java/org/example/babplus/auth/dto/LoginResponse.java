package org.example.babplus.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.user.projection.UserInfo;

@Getter
@ToString
public class LoginResponse {
    private final String loginId;
    private final String customerKey;
    private final TicketWalletInfo ticketWalletInfo;
    private final String token;

    @Builder
    @Getter
    public static class TicketWalletInfo{
        private final Long id;
        private final Integer balance;

        public static TicketWalletInfo of(UserInfo userInfo){
            return TicketWalletInfo.builder()
                    .id(userInfo.getTicketWalletId())
                    .balance(userInfo.getTicketWalletBalance())
                    .build();
        }
    }

    public LoginResponse(UserInfo userInfo, String token) {
        this.loginId = userInfo.getId();
        this.customerKey = userInfo.getCustomerKey();
        this.ticketWalletInfo = TicketWalletInfo.of(userInfo);
        this.token = token;
    }
}
