package org.example.babplus.user.factory;

import org.example.babplus.ticketWallet.entity.TicketWallet;
import org.example.babplus.user.entity.User;
import org.example.babplus.user.vo.JoinVO;

public class UserFactory {

    public static User create(JoinVO request, String encodedPassword) {
        var user =  User.builder()
                .id(request.getId())
                .password(encodedPassword)
                .name(request.getName())
                .role(request.getRole())
                .enable(request.isEnable())
                .build();

        var ticketWallet = TicketWallet.builder()
                .balance(0)
                .user(user)
                .build();

        user.assignWallet(ticketWallet);
        return user;
    }
}
