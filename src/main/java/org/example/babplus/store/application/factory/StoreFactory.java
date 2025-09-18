package org.example.babplus.store.application.factory;

import org.example.babplus.store.domain.Store;
import org.example.babplus.store.application.dto.command.RegisterCommand;
import org.example.babplus.user.domain.User;

public class StoreFactory {

    public static Store create(RegisterCommand registerCommand, User user) {
        return Store.builder()
                .user(user)
                .name(registerCommand.getName())
                .address(registerCommand.getAddress())
                .hotline(registerCommand.getHotline())
                .enable(registerCommand.getEnable())
                .build();
    }
}
