package org.example.babplus.store.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.babplus.common.dto.response.CommonResponse;
import org.example.babplus.store.dto.request.GetStoresRequest;
import org.example.babplus.store.dto.request.PatchStoreRequest;
import org.example.babplus.store.dto.request.RegisterStoreRequest;
import org.example.babplus.store.dto.response.GetStoreResponse;
import org.example.babplus.store.dto.response.PatchStoreResponse;
import org.example.babplus.store.service.StoreService;
import org.example.babplus.store.vo.PatchVO;
import org.example.babplus.store.vo.RegisterVO;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping()
    @Operation(summary = "매장 리스트 조회", description = "매장 리스트 조회")
    public CommonResponse<?> getStores(@ParameterObject GetStoresRequest request, Pageable pageable) {
        var response = storeService.getStores(request, pageable);

        return CommonResponse.success(response);
    }

    @GetMapping("/{store-id}")
    @Operation(summary = "매장 단일 조회", description = "매장 단일 조회")
    public CommonResponse<?> getStore(@PathVariable("store-id") Long storeId){
        var storeInfo = storeService.getStore(storeId);
        var response = GetStoreResponse.of(storeInfo);

        return CommonResponse.success(response);
    }

    @PostMapping()
    @Operation(summary = "매장 등록", description = "매장 등록")
    public CommonResponse<?> register(@Parameter(hidden = true) @AuthenticationPrincipal UserDetails userDetails, @RequestBody RegisterStoreRequest request){
        var paramVO = RegisterVO.of(request, userDetails.getUsername());
        storeService.register(paramVO);

        return CommonResponse.success();
    }

    @PatchMapping("/{store-id}")
    @Operation(summary = "매장 업데이트", description = "매장 업데이트")
    public CommonResponse<?> patch(@PathVariable("store-id") Long storeId, @RequestBody PatchStoreRequest request){
        var paramVO = PatchVO.of(request, storeId);
        var storeInfo = storeService.patch(paramVO);
        var response = PatchStoreResponse.of(storeInfo);

        return CommonResponse.success(response);
    }
}
