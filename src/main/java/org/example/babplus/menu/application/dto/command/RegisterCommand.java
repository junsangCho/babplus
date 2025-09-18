package org.example.babplus.menu.application.dto.command;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.menu.presentation.dto.request.RegisterMenuRequest;
import org.example.babplus.menu.domain.MealType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class RegisterCommand {

    private final Long storeId;
    private final List<String> menuItemNames;
    private final LocalDate menuDate;
    private final MealType mealType;

    public static RegisterCommand of(RegisterMenuRequest request, Long storeId){
        return RegisterCommand.builder()
                .storeId(storeId)
                .menuItemNames(request.getMenuItemNames())
                .menuDate(request.getMenuDate())
                .mealType(request.getMealType())
                .build();
    }
}
