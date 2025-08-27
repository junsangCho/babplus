package org.example.babplus.menu.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.menu.enums.MealType;
import org.example.babplus.menu.projection.MenuInfo;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@Builder
public class GetMenuResponse {
    private final Long id;
    private final Long storeId;
    private final List<String> menuNames;
    private final LocalDate menuDate;
    private final MealType mealType;

    public static GetMenuResponse of(MenuInfo menuInfo) {
        return GetMenuResponse.builder()
                .id(menuInfo.getId())
                .storeId(menuInfo.getStoreId())
                .menuNames(menuInfo.getMenuItemNames())
                .menuDate(menuInfo.getMenuDate())
                .mealType(menuInfo.getMealType())
                .build();
    }
}
