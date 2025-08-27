package org.example.babplus.menu.factory;

import org.example.babplus.menu.entity.Menu;
import org.example.babplus.menu.vo.RegisterVO;
import org.example.babplus.menuItem.entity.MenuItem;
import org.example.babplus.store.entity.Store;

public class MenuFactory {

    public static Menu create(RegisterVO registerVO, Store store) {
        var menu = Menu.builder()
                .store(store)
                .menuDate(registerVO.getMenuDate())
                .mealType(registerVO.getMealType())
                .build();

        if(registerVO.getMenuItemNames() != null)
            registerVO.getMenuItemNames().stream()
                    .map(MenuItem::new)
                    .forEach(menu::addItem);

        return menu;
    }
}
