package org.example.babplus.menu.application.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.menu.application.factory.MenuFactory;
import org.example.babplus.menu.infrastructure.persistence.projection.MenuInfo;
import org.example.babplus.menu.application.repository.MenuRepository;
import org.example.babplus.menu.application.dto.command.PatchCommand;
import org.example.babplus.menu.application.dto.command.RegisterCommand;
import org.example.babplus.store.application.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;


    public MenuInfo getMenu(Long menuId, Long storeId) {
        return menuRepository.getMenu(menuId, storeId).orElseThrow();
    }

    @Transactional
    public void register(RegisterCommand registerCommand){
        var store = storeRepository.findById(registerCommand.getStoreId()).orElseThrow();
        var menu = MenuFactory.create(registerCommand, store);

        menuRepository.save(menu);
    }

    @Transactional
    public MenuInfo patch(PatchCommand patchCommand){
        var menu = menuRepository.findByIdAndStoreId(patchCommand.getMenuId(), patchCommand.getStoreId()).orElseThrow();
        menu.patch(patchCommand);

        return new MenuInfo(menu);
    }
}
