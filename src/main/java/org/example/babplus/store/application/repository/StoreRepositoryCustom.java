package org.example.babplus.store.application.repository;

import org.example.babplus.store.presentation.dto.request.GetStoresRequest;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreRepositoryCustom {
    Page<StoreInfo> getStores(GetStoresRequest request, Pageable pageable);
}
