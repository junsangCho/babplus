package org.example.babplus.menu.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.menu.presentation.dto.request.PatchMenuRequest;
import org.example.babplus.menu.domain.MealType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PatchCommand {

    private final Long menuId;
    private final Long storeId;
    private final LocalDate menuDate;
    private final MealType mealType;
    private final List<String> menuItemNames;

    public static PatchCommand of(PatchMenuRequest request, Long menuId, Long storeId) {
        return PatchCommand.builder()
                .menuId(menuId)
                .storeId(storeId)
                .menuDate(request.getMenuDate())
                .mealType(request.getMealType())
                .menuItemNames(request.getMenuItemNames())
                .build();
    }
}
