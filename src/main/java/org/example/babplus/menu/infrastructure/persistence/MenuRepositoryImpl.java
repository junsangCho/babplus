package org.example.babplus.menu.infrastructure.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.babplus.menu.application.repository.MenuRepositoryCustom;
import org.example.babplus.menu.infrastructure.persistence.projection.MenuInfo;
import org.example.babplus.menu.infrastructure.persistence.projection.MenuItemInfo;
import org.example.babplus.store.infrastructure.persistence.projection.StoreInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Supplier;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static org.example.babplus.menu.domain.QMenu.menu;
import static org.example.babplus.menu.domain.QMenuItem.menuItem;


@RequiredArgsConstructor
@Repository
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<MenuInfo> getMenu(Long menuId, Long storeId) {
        return Optional.ofNullable(jpaQueryFactory.from(menu)
                    .leftJoin(menu.menuItems, menuItem)
                    .where(menu.id.eq(menuId).and(menu.store.id.eq(storeId)))
                    .transform(
                        groupBy(menu.id).as(
                            Projections.fields(MenuInfo.class,
                                    menu.id,
                                    Projections.fields(StoreInfo.class, menu.store.id).as("store"),
                                    menu.menuDate,
                                    menu.mealType,
                                    menu.createdDate,
                                    menu.updatedDate,
                                    list(Projections.fields(MenuItemInfo.class,
                                            menuItem.name
                                    )).as("menuItems")
                            )
                        )
                    ).get(menuId));
    }

    private BooleanBuilder nullSafeBooleanBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
