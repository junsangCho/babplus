package org.example.babplus.User.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.User.Entity.User;

@Getter
@ToString
@NoArgsConstructor
public class UserInfo {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String role;
    private boolean enable;

    public UserInfo(User user){
        this.id = user.getId();
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.role = user.getRole();
        this.enable = user.isEnable();
    }
}