package org.example.babplus.store.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.store.presentation.dto.request.RegisterStoreRequest;

@Getter
@Builder
public class RegisterCommand {

    private final String userId;
    private final String name;
    private final String address;
    private final String hotline;
    private final Boolean enable;

    public static RegisterCommand of(RegisterStoreRequest request, String userId){
        return RegisterCommand.builder()
                .userId(userId)
                .address(request.getAddress())
                .name(request.getName())
                .hotline(request.getHotline())
                .enable(true)
                .build();
    }
}
