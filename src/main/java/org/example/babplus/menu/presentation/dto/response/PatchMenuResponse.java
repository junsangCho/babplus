package org.example.babplus.menu.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.menu.domain.MealType;
import org.example.babplus.menu.infrastructure.persistence.projection.MenuInfo;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@Builder
public class PatchMenuResponse {
    private final Long id;
    private final Long storeId;
    private final List<String> menuNames;
    private final LocalDate menuDate;
    private final MealType mealType;

    public static PatchMenuResponse of(MenuInfo menuInfo) {
        return PatchMenuResponse.builder()
                .id(menuInfo.getId())
                .storeId(menuInfo.getStoreId())
                .menuNames(menuInfo.getMenuItemNames())
                .menuDate(menuInfo.getMenuDate())
                .mealType(menuInfo.getMealType())
                .build();
    }
}
