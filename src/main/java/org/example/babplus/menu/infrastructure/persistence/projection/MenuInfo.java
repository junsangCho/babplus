package org.example.babplus.menu.infrastructure.persistence.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.menu.domain.Menu;
import org.example.babplus.menu.domain.MealType;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class MenuInfo {
    private Long id;
    private StoreInfo store;
    private List<MenuItemInfo> menuItems;
    private LocalDate menuDate;
    private MealType mealType;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public MenuInfo(Menu menu){
        this.id = menu.getId();
        this.store = menu.getStore() == null ? null : new StoreInfo(menu.getStore());
        this.menuItems = menu.getMenuItems() == null ? null : MenuItemInfo.of(menu.getMenuItems());
        this.menuDate = menu.getMenuDate();
        this.mealType = menu.getMealType();
        this.createdDate = menu.getCreatedDate();
        this.updatedDate = menu.getUpdatedDate();
    }

    public Long getStoreId(){
        return this.store == null ? null : this.store.getId();
    }

    public List<String> getMenuItemNames(){
        return this.menuItems == null ? null : this.menuItems.stream()
                .map(MenuItemInfo::getName)
                .toList();
    }

}