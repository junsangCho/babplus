package org.example.babplus.store.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterStoreRequest {
    @Schema(description = "매장명")
    private String name;

    @Schema(description = "매장주소")
    private String address;

    @Schema(description = "매장전화번호", example = "02-3491-3439")
    private String hotline;
}
