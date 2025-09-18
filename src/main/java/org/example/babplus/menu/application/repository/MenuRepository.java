package org.example.babplus.menu.application.repository;

import org.example.babplus.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositoryCustom {
    Optional<Menu> findByIdAndStoreId(Long menuId, Long storeId);
}