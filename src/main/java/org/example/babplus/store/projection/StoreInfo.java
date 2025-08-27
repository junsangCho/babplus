package org.example.babplus.store.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.store.entity.Store;
import org.example.babplus.user.projection.UserInfo;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class StoreInfo {
    private Long id;
    private UserInfo user;
    private String name;
    private String address;
    private String hotline;
    private boolean enable;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public StoreInfo(Store store){
        this.id = store.getId();
        this.user = store.getUser() == null ? null : new UserInfo(store.getUser());
        this.name = store.getName();
        this.address = store.getAddress();
        this.hotline = store.getHotline();
        this.enable = store.getEnable();
        this.createdDate = store.getCreatedDate();
        this.updatedDate = store.getUpdatedDate();
    }

    public String getUserId(){
        return this.user == null ? null : this.user.getId();
    }
}