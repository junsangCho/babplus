package org.example.babplus.menu.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.menu.dto.request.PatchMenuRequest;
import org.example.babplus.menu.enums.MealType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PatchVO {

    private final Long menuId;
    private final Long storeId;
    private final LocalDate menuDate;
    private final MealType mealType;
    private final List<String> menuItemNames;

    public static PatchVO of(PatchMenuRequest request, Long menuId, Long storeId) {
        return PatchVO.builder()
                .menuId(menuId)
                .storeId(storeId)
                .menuDate(request.getMenuDate())
                .mealType(request.getMealType())
                .menuItemNames(request.getMenuItemNames())
                .build();
    }
}
