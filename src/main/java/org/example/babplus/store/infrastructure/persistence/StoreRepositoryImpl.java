package org.example.babplus.store.infrastructure.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.store.application.repository.StoreRepositoryCustom;
import org.example.babplus.store.presentation.dto.request.GetStoresRequest;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;
import org.example.babplus.user.infrastructure.persistence.projection.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

import static org.example.babplus.store.domain.QStore.store;
import static org.example.babplus.user.domain.QUser.user;


@RequiredArgsConstructor
@Repository
public class StoreRepositoryImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<StoreInfo> getStores(GetStoresRequest request, Pageable pageable) {
        List<StoreInfo> content = jpaQueryFactory.select(Projections.fields(StoreInfo.class,
                        store.id,
                        Projections.fields(UserInfo.class,user.id).as("user"),
                        store.name,
                        store.address,
                        store.hotline,
                        store.enable,
                        store.createdDate,
                        store.updatedDate
                        ))
                .from(store)
                .where(nullSafeBooleanBuilder(()->store.name.contains(request.getName())))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(store.createdDate.desc())
                .fetch();

        Long total = jpaQueryFactory.select(store.count())
                .from(store)
                .where(nullSafeBooleanBuilder(()->store.name.contains(request.getName())))
                .fetchOne();

        return new PageImpl<>(content,pageable,total != null ? total : 0);
    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
