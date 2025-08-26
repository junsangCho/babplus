package org.example.babplus.store.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.store.dto.request.PatchStoreRequest;

@Getter
@Builder
public class PatchVO {

    private final String userId;
    private final String name;
    private final String address;
    private final String hotline;
    private final Boolean enable;

    public static PatchVO of(PatchStoreRequest request){
        return PatchVO.builder()
                .address(request.getAddress())
                .name(request.getName())
                .hotline(request.getHotline())
                .enable(true)
                .build();
    }
}
