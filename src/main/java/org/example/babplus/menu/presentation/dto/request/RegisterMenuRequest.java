package org.example.babplus.menu.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.babplus.menu.domain.MealType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class RegisterMenuRequest {
    @Schema(description = "일자")
    private LocalDate menuDate;

    @Schema(description = "타입")
    private MealType mealType;

    @Schema(description = "메뉴이름")
    private List<String> menuItemNames;
}
