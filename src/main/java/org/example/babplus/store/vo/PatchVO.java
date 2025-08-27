package org.example.babplus.store.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.store.dto.request.PatchStoreRequest;

@Getter
@Builder
public class PatchVO {

    private final Long storeId;
    private final String name;
    private final String address;
    private final String hotline;
    private final Boolean enable;

    public static PatchVO of(PatchStoreRequest request, Long storeId) {
        return PatchVO.builder()
                .storeId(storeId)
                .address(request.getAddress())
                .name(request.getName())
                .hotline(request.getHotline())
                .enable(true)
                .build();
    }
}
