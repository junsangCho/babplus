package org.example.babplus.user.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.user.entity.User;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class UserInfo {
    private String id;
    private String password;
    private String name;
    private String role;
    private String customerKey;
    private boolean enable;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public UserInfo(User user){
        this.id = user.getId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.role = user.getRole();
        this.customerKey = user.getCustomerKey();
        this.enable = user.isEnable();
        this.createdDate = user.getCreatedDate();
        this.updatedDate = user.getUpdatedDate();
    }
}