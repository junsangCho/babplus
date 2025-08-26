package org.example.babplus.store.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.store.dto.request.RegisterStoreRequest;

@Getter
@Builder
public class RegisterVO {

    private final String userId;
    private final String name;
    private final String address;
    private final String hotline;
    private final Boolean enable;

    public static RegisterVO of(RegisterStoreRequest request, String userId){
        return RegisterVO.builder()
                .userId(userId)
                .address(request.getAddress())
                .name(request.getName())
                .hotline(request.getHotline())
                .enable(true)
                .build();
    }
}
