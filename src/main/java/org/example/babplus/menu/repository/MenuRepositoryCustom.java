package org.example.babplus.menu.repository;

import org.example.babplus.menu.projection.MenuInfo;

import java.util.Optional;

public interface MenuRepositoryCustom {
    Optional<MenuInfo> getMenu(Long menuId, Long storeId);
}
