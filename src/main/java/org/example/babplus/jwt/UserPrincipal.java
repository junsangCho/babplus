package org.example.babplus.jwt;

import org.example.babplus.User.projection.UserInfo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {
    public UserPrincipal(UserInfo user) {
        super(user.getLoginId(), user.getPassword(), user.isEnable(), true, true, true, List.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
