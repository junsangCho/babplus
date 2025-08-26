package org.example.babplus.store.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.User.repository.UserRepository;
import org.example.babplus.store.dto.request.GetStoresRequest;
import org.example.babplus.store.factory.StoreFactory;
import org.example.babplus.store.projection.StoreInfo;
import org.example.babplus.store.repository.StoreRepository;
import org.example.babplus.store.vo.PatchVO;
import org.example.babplus.store.vo.RegisterVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public Page<StoreInfo> getStores(GetStoresRequest request, Pageable pageable){
        return storeRepository.getStores(request, pageable);
    }

    public StoreInfo getStore(Long storeId){
        return storeRepository.findById(storeId)
                .map(StoreInfo::new).orElseThrow();
    }

    @Transactional
    public void register(RegisterVO registerVO){
        var user = userRepository.findById(registerVO.getUserId()).orElseThrow();
        var store = StoreFactory.create(registerVO, user);

        storeRepository.save(store);
    }

    @Transactional
    public StoreInfo patch(PatchVO patchVO, Long storeId){
        var store = storeRepository.findById(storeId).orElseThrow();
        store.patch(patchVO);

        return new StoreInfo(store);
    }
}
