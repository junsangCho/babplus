package org.example.babplus.menuItem.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.babplus.menuItem.entity.MenuItem;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class MenuItemInfo {
    private Long id;
    private Long menuId;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public MenuItemInfo(MenuItem menuItem){
        this.id = menuItem.getId();
        this.menuId = menuItem.getMenu() == null ? null : menuItem.getMenuId();
        this.name = menuItem.getName();
        this.createdDate = menuItem.getCreatedDate();
        this.updatedDate = menuItem.getUpdatedDate();
    }

    public static List<MenuItemInfo> of(List<MenuItem> menuItems) {
        return menuItems.stream()
                .map(MenuItemInfo::new)
                .toList();
    }

}