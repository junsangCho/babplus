package org.example.babplus.store.application.service;

import lombok.RequiredArgsConstructor;
import org.example.babplus.store.presentation.dto.request.GetStoresRequest;
import org.example.babplus.store.application.factory.StoreFactory;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;
import org.example.babplus.store.application.repository.StoreRepository;
import org.example.babplus.store.application.dto.command.PatchCommand;
import org.example.babplus.store.application.dto.command.RegisterCommand;
import org.example.babplus.user.application.repository.UserRepository;
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
    public void register(RegisterCommand registerCommand){
        var user = userRepository.findById(registerCommand.getUserId()).orElseThrow();
        var store = StoreFactory.create(registerCommand, user);

        storeRepository.save(store);
    }

    @Transactional
    public StoreInfo patch(PatchCommand patchCommand){
        var store = storeRepository.findById(patchCommand.getStoreId()).orElseThrow();
        store.patch(patchCommand);

        return new StoreInfo(store);
    }
}
