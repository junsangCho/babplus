package org.example.babplus.jwt.infrastructure;

import org.example.babplus.user.infrastructure.persistence.projection.UserInfo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {
    public UserPrincipal(UserInfo user) {
        super(user.getId(), user.getPassword(), user.isEnable(), true, true, true, List.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
