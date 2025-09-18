package org.example.babplus.menu.application.factory;

import org.example.babplus.menu.domain.Menu;
import org.example.babplus.menu.domain.MenuItem;
import org.example.babplus.menu.application.dto.command.RegisterCommand;
import org.example.babplus.store.domain.Store;

public class MenuFactory {

    public static Menu create(RegisterCommand registerCommand, Store store) {
        var menu = Menu.builder()
                .store(store)
                .menuDate(registerCommand.getMenuDate())
                .mealType(registerCommand.getMealType())
                .build();

        if(registerCommand.getMenuItemNames() != null)
            registerCommand.getMenuItemNames().stream()
                    .map(MenuItem::new)
                    .forEach(menu::addItem);

        return menu;
    }
}
