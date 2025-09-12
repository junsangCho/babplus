package org.example.babplus.menu.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.menu.dto.request.PatchMenuRequest;
import org.example.babplus.menu.dto.request.RegisterMenuRequest;
import org.example.babplus.menu.dto.response.GetMenuResponse;
import org.example.babplus.menu.dto.response.PatchMenuResponse;
import org.example.babplus.menu.service.MenuService;
import org.example.babplus.menu.vo.PatchVO;
import org.example.babplus.menu.vo.RegisterVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores/{store-id}/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menu-id}")
    @Operation(summary = "식사메뉴 단일 조회", description = "식사메뉴 단일 조회")
    public CommonResponse<?> getMenu(@PathVariable("menu-id") Long menuId, @PathVariable("store-id") Long storeId) {
        var menuInfo = menuService.getMenu(menuId, storeId);
        var response = GetMenuResponse.of(menuInfo);

        return CommonResponse.success(response);
    }

    @PostMapping()
    @Operation(summary = "식사메뉴 등록", description = "식사메뉴 등록")
    public CommonResponse<?> register(@PathVariable("store-id") Long storeId, @RequestBody RegisterMenuRequest request){
        var paramVO = RegisterVO.of(request,storeId);
        menuService.register(paramVO);

        return CommonResponse.success();
    }

    @PatchMapping("/{menu-id}")
    @Operation(summary = "식사메뉴 업데이트", description = "식사메뉴 업데이트")
    public CommonResponse<?> patch(@PathVariable("menu-id") Long menuId,@PathVariable("store-id") Long storeId, @RequestBody PatchMenuRequest request){
        var paramVO = PatchVO.of(request, menuId, storeId);
        var menuInfo = menuService.patch(paramVO);
        var response = PatchMenuResponse.of(menuInfo);

        return CommonResponse.success(response);
    }
}
