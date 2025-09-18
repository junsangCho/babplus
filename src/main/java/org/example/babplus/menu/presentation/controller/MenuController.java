package org.example.babplus.menu.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.menu.presentation.dto.request.PatchMenuRequest;
import org.example.babplus.menu.presentation.dto.request.RegisterMenuRequest;
import org.example.babplus.menu.presentation.dto.response.GetMenuResponse;
import org.example.babplus.menu.presentation.dto.response.PatchMenuResponse;
import org.example.babplus.menu.application.service.MenuService;
import org.example.babplus.menu.application.dto.command.PatchCommand;
import org.example.babplus.menu.application.dto.command.RegisterCommand;
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
        var paramVO = RegisterCommand.of(request,storeId);
        menuService.register(paramVO);

        return CommonResponse.success();
    }

    @PatchMapping("/{menu-id}")
    @Operation(summary = "식사메뉴 업데이트", description = "식사메뉴 업데이트")
    public CommonResponse<?> patch(@PathVariable("menu-id") Long menuId,@PathVariable("store-id") Long storeId, @RequestBody PatchMenuRequest request){
        var paramVO = PatchCommand.of(request, menuId, storeId);
        var menuInfo = menuService.patch(paramVO);
        var response = PatchMenuResponse.of(menuInfo);

        return CommonResponse.success(response);
    }
}
