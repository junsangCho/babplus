package org.example.babplus.store.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.store.presentation.dto.request.PatchStoreRequest;

@Getter
@Builder
public class PatchCommand {

    private final Long storeId;
    private final String name;
    private final String address;
    private final String hotline;
    private final Boolean enable;

    public static PatchCommand of(PatchStoreRequest request, Long storeId) {
        return PatchCommand.builder()
                .storeId(storeId)
                .address(request.getAddress())
                .name(request.getName())
                .hotline(request.getHotline())
                .enable(true)
                .build();
    }
}
