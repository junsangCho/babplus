package org.example.babplus.store.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;

@Getter
@ToString
@Builder
public class PatchStoreResponse {
    private final Long id;
    private final String userId;
    private final String name;
    private final String address;
    private final String hotline;
    private final boolean enable;

    public static PatchStoreResponse of(StoreInfo storeInfo) {
        return PatchStoreResponse.builder()
                .id(storeInfo.getId())
                .userId(storeInfo.getUserId())
                .name(storeInfo.getName())
                .address(storeInfo.getAddress())
                .hotline(storeInfo.getHotline())
                .enable(storeInfo.isEnable())
                .build();
    }
}
