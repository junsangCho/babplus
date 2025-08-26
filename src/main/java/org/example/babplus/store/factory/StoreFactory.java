package org.example.babplus.store.factory;

import org.example.babplus.User.Entity.User;
import org.example.babplus.store.entity.Store;
import org.example.babplus.store.vo.RegisterVO;

public class StoreFactory {

    public static Store create(RegisterVO registerVO, User user) {
        return Store.builder()
                .user(user)
                .name(registerVO.getName())
                .address(registerVO.getAddress())
                .hotline(registerVO.getHotline())
                .enable(registerVO.getEnable())
                .build();
    }
}
