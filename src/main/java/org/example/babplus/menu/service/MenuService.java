package org.example.babplus.menu.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.menu.factory.MenuFactory;
import org.example.babplus.menu.projection.MenuInfo;
import org.example.babplus.menu.repository.MenuRepository;
import org.example.babplus.menu.vo.PatchVO;
import org.example.babplus.menu.vo.RegisterVO;
import org.example.babplus.store.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;


    public MenuInfo getMenu(Long menuId) {
        return menuRepository.findById(menuId)
                .map(MenuInfo::new).orElseThrow();
    }

    @Transactional
    public void register(RegisterVO registerVO){
        var store = storeRepository.findById(registerVO.getStoreId()).orElseThrow();
        var menu = MenuFactory.create(registerVO, store);

        menuRepository.save(menu);
    }

    @Transactional
    public MenuInfo patch(PatchVO patchVO){
        var menu = menuRepository.findById(patchVO.getMenuId()).orElseThrow();
        menu.patch(patchVO);

        return new MenuInfo(menu);
    }
}
