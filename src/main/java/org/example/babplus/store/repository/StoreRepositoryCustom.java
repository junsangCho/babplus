package org.example.babplus.store.repository;

import org.example.babplus.store.dto.request.GetStoresRequest;
import org.example.babplus.store.projection.StoreInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreRepositoryCustom {
    Page<StoreInfo> getStores(GetStoresRequest request, Pageable pageable);
}
