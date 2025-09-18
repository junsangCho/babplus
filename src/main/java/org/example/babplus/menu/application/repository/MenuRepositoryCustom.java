package org.example.babplus.menu.application.repository;

import org.example.babplus.menu.infrastructure.persistence.projection.MenuInfo;

import java.util.Optional;

public interface MenuRepositoryCustom {
    Optional<MenuInfo> getMenu(Long menuId, Long storeId);
}
