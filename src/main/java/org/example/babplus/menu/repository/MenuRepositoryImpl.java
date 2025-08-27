package org.example.babplus.menu.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;


@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

//    @Override
//    public Page<MenuInfo> getMenus(GetStoresRequest request, Pageable pageable) {
//        List<MenuInfo> content = jpaQueryFactory.select(Projections.fields(StoreInfo.class,
//                        store.id,
//                        Projections.fields(UserInfo.class,user.id).as("user"),
//                        store.name,
//                        store.address,
//                        store.hotline,
//                        store.enable,
//                        store.createdDate,
//                        store.updatedDate
//                        ))
//                .from(store)
//                .where(nullSafeBooleanBuilder(()->store.name.contains(request.getName())))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(store.createdDate.desc())
//                .fetch();
//
//        Long total = jpaQueryFactory.select(store.count())
//                .from(store)
//                .where(nullSafeBooleanBuilder(()->store.name.contains(request.getName())))
//                .fetchOne();
//
//        return new PageImpl<>(content,pageable,total != null ? total : 0);
//    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
