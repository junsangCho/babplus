package org.example.babplus.menu.vo;

import lombok.Builder;
import lombok.Getter;
import org.example.babplus.menu.dto.request.RegisterMenuRequest;
import org.example.babplus.menu.enums.MealType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class RegisterVO {

    private final Long storeId;
    private final List<String> menuItemNames;
    private final LocalDate menuDate;
    private final MealType mealType;

    public static RegisterVO of(RegisterMenuRequest request, Long storeId){
        return RegisterVO.builder()
                .storeId(storeId)
                .menuItemNames(request.getMenuItemNames())
                .menuDate(request.getMenuDate())
                .mealType(request.getMealType())
                .build();
    }
}
