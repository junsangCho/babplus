package org.example.babplus.store.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetStoresRequest {
    @Schema(description = "매장명")
    private String name;
}
